package com.strandls.mail.service.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.strandls.mail.service.CCAMailService;
import com.strandls.mail.service.DataTableMailService;
import com.strandls.mail.service.DocumentMailService;
import com.strandls.mail.service.ObservationMailService;
import com.strandls.mail.service.PageMailService;
import com.strandls.mail.service.PermisisonMailService;
import com.strandls.mail.service.SpeciesMailService;
import com.strandls.mail.service.UserGroupService;
import com.strandls.mail.service.UserMailService;

public class ServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(UserMailService.class).to(UserMailServiceImpl.class).in(Scopes.SINGLETON);
		bind(ObservationMailService.class).to(ObservationMailServiceImpl.class).in(Scopes.SINGLETON);
		bind(UserGroupService.class).to(UserGroupServiceImpl.class).in(Scopes.SINGLETON);
		bind(PermisisonMailService.class).to(PermisisonMailServiceImpl.class).in(Scopes.SINGLETON);
		bind(CCAMailService.class).to(CCAMailServiceImpl.class).in(Scopes.SINGLETON);
		bind(DocumentMailService.class).to(DocumentMailServiceImpl.class).in(Scopes.SINGLETON);
		bind(PageMailService.class).to(PageMailServiceImpl.class).in(Scopes.SINGLETON);
		bind(SpeciesMailService.class).to(SpeciesMailServiceImpl.class).in(Scopes.SINGLETON);
		bind(DataTableMailService.class).to(DataTableServiceImpl.class).in(Scopes.SINGLETON);
	}

}
