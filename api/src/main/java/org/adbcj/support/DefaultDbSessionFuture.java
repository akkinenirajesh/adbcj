/*
 *   Copyright (c) 2007 Mike Heath.  All rights reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
package org.adbcj.support;

import org.adbcj.DbException;
import org.adbcj.DbListener;
import org.adbcj.DbSession;
import org.adbcj.DbSessionFuture;

public class DefaultDbSessionFuture<T> extends DefaultDbFuture<T> implements DbSessionFuture<T> {

	private final DbSession session;
	
	public static <T> DefaultDbSessionFuture<T> createCompletedFuture(DbSession session, T value) {
		DefaultDbSessionFuture<T> future = new DefaultDbSessionFuture<T>(session);
		future.setResult(value);
		return future;
	}
	
	public static <T> DefaultDbSessionFuture<T> createCompletedErrorFuture(DbSession session, DbException exception) {
		DefaultDbSessionFuture<T> future = new DefaultDbSessionFuture<T>(session);
		future.setException(exception);
		return future;
	}
	
	@Override
	public DbSessionFuture<T> addListener(DbListener<T> listener) {
		super.addListener(listener);
		return this;
	}
	
	public DefaultDbSessionFuture(DbSession session) {
		this.session = session;
	}
	
	public DbSession getSession() {
		return session;
	}

}
