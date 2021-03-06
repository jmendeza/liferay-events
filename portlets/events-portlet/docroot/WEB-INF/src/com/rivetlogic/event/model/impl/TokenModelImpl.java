/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rivetlogic.event.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.rivetlogic.event.model.Token;
import com.rivetlogic.event.model.TokenModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Token service. Represents a row in the &quot;rivetlogic_event_Token&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rivetlogic.event.model.TokenModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TokenImpl}.
 * </p>
 *
 * @author juancarrillo
 * @see TokenImpl
 * @see com.rivetlogic.event.model.Token
 * @see com.rivetlogic.event.model.TokenModel
 * @generated
 */
public class TokenModelImpl extends BaseModelImpl<Token> implements TokenModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a token model instance should use the {@link com.rivetlogic.event.model.Token} interface instead.
	 */
	public static final String TABLE_NAME = "rivetlogic_event_Token";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "tokenId", Types.BIGINT },
			{ "participantId", Types.BIGINT },
			{ "expiredDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table rivetlogic_event_Token (uuid_ VARCHAR(75) null,tokenId LONG not null primary key,participantId LONG,expiredDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table rivetlogic_event_Token";
	public static final String ORDER_BY_JPQL = " ORDER BY token.tokenId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY rivetlogic_event_Token.tokenId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rivetlogic.event.model.Token"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rivetlogic.event.model.Token"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rivetlogic.event.model.Token"),
			true);
	public static long PARTICIPANTID_COLUMN_BITMASK = 1L;
	public static long UUID_COLUMN_BITMASK = 2L;
	public static long TOKENID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rivetlogic.event.model.Token"));

	public TokenModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _tokenId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTokenId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tokenId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Token.class;
	}

	@Override
	public String getModelClassName() {
		return Token.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("tokenId", getTokenId());
		attributes.put("participantId", getParticipantId());
		attributes.put("expiredDate", getExpiredDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long tokenId = (Long)attributes.get("tokenId");

		if (tokenId != null) {
			setTokenId(tokenId);
		}

		Long participantId = (Long)attributes.get("participantId");

		if (participantId != null) {
			setParticipantId(participantId);
		}

		Date expiredDate = (Date)attributes.get("expiredDate");

		if (expiredDate != null) {
			setExpiredDate(expiredDate);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getTokenId() {
		return _tokenId;
	}

	@Override
	public void setTokenId(long tokenId) {
		_tokenId = tokenId;
	}

	@Override
	public long getParticipantId() {
		return _participantId;
	}

	@Override
	public void setParticipantId(long participantId) {
		_columnBitmask |= PARTICIPANTID_COLUMN_BITMASK;

		if (!_setOriginalParticipantId) {
			_setOriginalParticipantId = true;

			_originalParticipantId = _participantId;
		}

		_participantId = participantId;
	}

	public long getOriginalParticipantId() {
		return _originalParticipantId;
	}

	@Override
	public Date getExpiredDate() {
		return _expiredDate;
	}

	@Override
	public void setExpiredDate(Date expiredDate) {
		_expiredDate = expiredDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Token.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Token toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Token)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TokenImpl tokenImpl = new TokenImpl();

		tokenImpl.setUuid(getUuid());
		tokenImpl.setTokenId(getTokenId());
		tokenImpl.setParticipantId(getParticipantId());
		tokenImpl.setExpiredDate(getExpiredDate());

		tokenImpl.resetOriginalValues();

		return tokenImpl;
	}

	@Override
	public int compareTo(Token token) {
		long primaryKey = token.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Token)) {
			return false;
		}

		Token token = (Token)obj;

		long primaryKey = token.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		TokenModelImpl tokenModelImpl = this;

		tokenModelImpl._originalUuid = tokenModelImpl._uuid;

		tokenModelImpl._originalParticipantId = tokenModelImpl._participantId;

		tokenModelImpl._setOriginalParticipantId = false;

		tokenModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Token> toCacheModel() {
		TokenCacheModel tokenCacheModel = new TokenCacheModel();

		tokenCacheModel.uuid = getUuid();

		String uuid = tokenCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			tokenCacheModel.uuid = null;
		}

		tokenCacheModel.tokenId = getTokenId();

		tokenCacheModel.participantId = getParticipantId();

		Date expiredDate = getExpiredDate();

		if (expiredDate != null) {
			tokenCacheModel.expiredDate = expiredDate.getTime();
		}
		else {
			tokenCacheModel.expiredDate = Long.MIN_VALUE;
		}

		return tokenCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", tokenId=");
		sb.append(getTokenId());
		sb.append(", participantId=");
		sb.append(getParticipantId());
		sb.append(", expiredDate=");
		sb.append(getExpiredDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.event.model.Token");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tokenId</column-name><column-value><![CDATA[");
		sb.append(getTokenId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>participantId</column-name><column-value><![CDATA[");
		sb.append(getParticipantId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiredDate</column-name><column-value><![CDATA[");
		sb.append(getExpiredDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Token.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Token.class };
	private String _uuid;
	private String _originalUuid;
	private long _tokenId;
	private long _participantId;
	private long _originalParticipantId;
	private boolean _setOriginalParticipantId;
	private Date _expiredDate;
	private long _columnBitmask;
	private Token _escapedModel;
}