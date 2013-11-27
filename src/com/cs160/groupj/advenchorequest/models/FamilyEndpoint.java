package com.cs160.groupj.advenchorequest.models;

import com.cs160.groupj.advenchorequest.EMF;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JPACursorHelper;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Api(name = "familyendpoint", namespace = @ApiNamespace(ownerDomain = "cs160.com", ownerName = "cs160.com", packagePath = "groupj.advenchorequest"))
public class FamilyEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listFamily")
	public CollectionResponse<Family> listFamily(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		EntityManager mgr = null;
		Cursor cursor = null;
		List<Family> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr.createQuery("select from Family as Family");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<Family>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Family obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Family> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getFamily")
	public Family getFamily(@Named("id") String id) {
		EntityManager mgr = getEntityManager();
		Family family = null;
		try {
			family = mgr.find(Family.class, id);
		} finally {
			mgr.close();
		}
		return family;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param family the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertFamily")
	public Family insertFamily(Family family) {
		EntityManager mgr = getEntityManager();
		try {
			if (containsFamily(family)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(family);
		} finally {
			mgr.close();
		}
		return family;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param family the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateFamily")
	public Family updateFamily(Family family) {
		EntityManager mgr = getEntityManager();
		try {
			if (!containsFamily(family)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.persist(family);
		} finally {
			mgr.close();
		}
		return family;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeFamily")
	public void removeFamily(@Named("id") String id) {
		EntityManager mgr = getEntityManager();
		try {
			Family family = mgr.find(Family.class, id);
			mgr.remove(family);
		} finally {
			mgr.close();
		}
	}

	private boolean containsFamily(Family family) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			Family item = mgr.find(Family.class, family.getId());
			if (item == null) {
				contains = false;
			}
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}

}
