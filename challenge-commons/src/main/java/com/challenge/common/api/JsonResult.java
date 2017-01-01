package com.challenge.common.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JsonResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
	private List<JsonDto> items;

	/**
     * 
     */
	private Object metaData;

	/**
	 * @return items
	 */
	public List<JsonDto> getItems() {

		return this.items;
	}

	/**
	 * @param items
	 *            the new value of items
	 */
	public void setItems(List<JsonDto> items) {

		this.items = items;
	}

	/**
	 * @return metaData
	 */
	public Object getMetaData() {

		return this.metaData;
	}

	/**
	 * @param metaData
	 *            the new value of metaData
	 */
	public void setMetaData(Object metaData) {

		this.metaData = metaData;
	}

	/**
	 * This method is adding a new item to the list and creates a new list if
	 * the item is the first one added.
	 * 
	 * @param item
	 */
	public void addItem(final JsonDto item) {

		if (this.items == null) {
			this.items = new ArrayList<JsonDto>();
		}

		this.items.add(item);
	}

}
