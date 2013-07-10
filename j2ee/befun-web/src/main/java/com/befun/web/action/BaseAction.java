package com.befun.web.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.befun.domain.profile.Client;
import com.befun.domain.profile.Employee;
import com.befun.domain.profile.Permission;
import com.befun.domain.profile.Profile;
import com.befun.domain.profile.RoleCode;
import com.befun.service.profile.ClientService;
import com.befun.service.security.MyUser;
import com.befun.web.box.SessionContainer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * The Class BaseAction.
 */
public class BaseAction extends ActionSupport {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5861808924393863221L;

    /** The logger. */
    protected Log log = LogFactory.getLog(this.getClass());

    /** Indicate if current request is json request. */
    private int jsonRequest = 0;

    @Resource
    @Qualifier("ClientService")
    protected ClientService clientService;

    protected boolean isAnonymous() {
        return this.getCurrentProfile() == null;
    }

    /**
     * Gets the current profile.
     *
     * @return the current profile
     */
    protected Profile getCurrentProfile() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof MyUser) {
            MyUser userDetails = (MyUser) principal;
            return userDetails.getProfile();
        } else {
            return null;
        }
    }

    protected Employee getCurrentEmployee() {
        if (this.getCurrentProfile() instanceof Employee) {
            return (Employee) this.getCurrentProfile();
        }
        return null;
    }

    /**
     * Gets the permissions.
     *
     * @return the permissions
     */
    protected List<Permission> getPermissions() {
        return new ArrayList<Permission>(0);
    }

    /**
     * Gets the current user name.
     *
     * @return the current user name
     */
    protected String getCurrentUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            return userDetails.getUsername();
        } else {
            return principal.toString();
        }
    }

    /**
     * Gets the current authrities.
     *
     * @return the current authrities
     */
    protected Collection<? extends GrantedAuthority> getCurrentAuthrities() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            return userDetails.getAuthorities();
        }
        this.log.warn("User details class not casted!");
        return new ArrayList<SimpleGrantedAuthority>();
    }

    /**
     * Contains all roles.
     *
     * @param roles the roles
     * @return true, if current profile contains all roles in <code>roles</code>, else return false
     */
    protected boolean containsAllRoles(RoleCode... roles) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            if (authorities == null) {
                return false;
            }
            labelA: for (RoleCode r : roles) {
                if (StringUtils.isEmpty(r)) {
                    continue;
                }
                for (GrantedAuthority a : authorities) {
                    if (r.name().equals(a.getAuthority())) {
                        continue labelA;
                    }
                }
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * Contains any roles.
     *
     * @param roles the roles
     * @return true, if current profile contains any role in <code>roles</code>, else return false
     */
    protected boolean containsAnyRoles(RoleCode... roles) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            if (authorities == null) {
                return false;
            }
            for (RoleCode r : roles) {
                for (GrantedAuthority a : authorities) {
                    if (r.name().equals(a.toString())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    protected boolean isJsonRequest() {
        return this.jsonRequest > 0;
    }

    protected HttpServletRequest getRequest() {
        ActionContext ctx = ActionContext.getContext();
        HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
        return request;
    }

    protected HttpServletResponse getResponse() {
        ActionContext ctx = ActionContext.getContext();
        HttpServletResponse response = (HttpServletResponse) ctx.get(ServletActionContext.HTTP_RESPONSE);
        return response;
    }

    protected HttpSession getSession() {
        return getRequest().getSession(true);
    }

    protected Serializable getSessionProperty(String propertyName) {
        HttpSession session = this.getSession();
        synchronized (session) {
            Object c = session.getAttribute("befunContainer");
            SessionContainer container = null;
            if (c == null) {
                container = new SessionContainer();
                session.setAttribute("befunContainer", container);
            } else if (!(c instanceof SessionContainer)) {
                this.log.warn("BefunContainer destroyed by illegal code!");
                container = new SessionContainer();
                session.setAttribute("befunContainer", container);
            } else {
                container = (SessionContainer) c;
            }
            return container.getProperty(propertyName);
        }
    }

    protected void setSessionProperty(String propertyName, Serializable property) {
        HttpSession session = this.getSession();
        synchronized (session) {
            Object c = session.getAttribute("befunContainer");
            SessionContainer container = null;
            if (c == null) {
                container = new SessionContainer();
                session.setAttribute("befunContainer", container);
            } else if (!(c instanceof SessionContainer)) {
                this.log.warn("BefunContainer destroyed by illegal code!");
                container = new SessionContainer();
                session.setAttribute("befunContainer", container);
            } else {
                container = (SessionContainer) c;
            }
            container.setProperty(propertyName, property);
        }
    }

    public Long getCurrentClientId() {
        return (Long) this.getSessionProperty("currentClient");
    }

    public boolean isCurrentSaleOfClient(Long clientId) {
        Long currentProfileId = this.getCurrentProfile().getId();
        Client c = clientService.get(clientId);
        if (c == null || c.getCurrentEmployee() == null) {
            return false;
        }
        return c.getCurrentEmployee().getId().equals(currentProfileId);
    }
}
