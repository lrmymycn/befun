package com.befun.web.action;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("IndexAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class IndexAction extends BaseAction {

    private static final long serialVersionUID = 3949957435980665954L;

    @Override
    public String getCurrentUserName() {
        return super.getCurrentUserName();
    }

}
