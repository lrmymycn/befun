<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div id="compare-panel">
	<div class="tab up">
		<span class="arrow"></span>
	</div>
	<div class="title">
		<div class="inner">
			<i class="list"></i> Compare list
		</div>
	</div>
	<div class="panel clearfix">
		<div class="list">
			<div class="arrow"></div>
			<ul>
				<li>
					<span class="delete"></span>
					<div class="slot" data-id="">
						<span>1</span>
					</div>
				</li>
				<li>
					<span class="delete"></span>
					<div class="slot" data-id="">
						<span>2</span>
					</div>
				</li>
				<li>
					<span class="delete"></span>
					<div class="slot" data-id="">
						<span>3</span>
					</div>
				</li>
				<li>
					<span class="delete"></span>
					<div class="slot" data-id="">
						<span>4</span>
					</div>
				</li>
			</ul>
		</div>
		<div class="button">
			<a href="compare.jsp" target="_blank" class="btn-compare disabled">Compare</a>
			<a href="#" class="clear">Clear the list</a>
		</div>
	</div>
</div>