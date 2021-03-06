/*******************************************************************************
 * Copyright (c) 2009 Siemens AG and others.
 * 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Kai Tödter - initial implementation
 ******************************************************************************/

package at.bestsolution.efxclipse.runtime.demo.contacts.model;

import at.bestsolution.efxclipse.runtime.demo.contacts.Contact;

import org.eclipse.core.databinding.observable.list.IObservableList;

public interface IContactsRepository {
	IObservableList getAllContacts();

	void addContact(Contact contact);

	void removeContact(Contact contact);
}
