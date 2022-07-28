/*
 * Copyright 2002-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.web.socket.client;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

import org.springframework.lang.Nullable;
import org.springframework.util.concurrent.CompletableToListenableFutureAdapter;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;

/**
 * Contract for initiating a WebSocket request. As an alternative considering using the
 * declarative style {@link WebSocketConnectionManager} that starts a WebSocket connection
 * to a pre-configured URI when the application starts.
 *
 * @author Rossen Stoyanchev
 * @since 4.0
 * @see WebSocketConnectionManager
 */
public interface WebSocketClient {

	/**
	 * Execute a handshake request to the given url and handle the resulting
	 * WebSocket session with the given handler.
	 * @param webSocketHandler the session handler
	 * @param uriTemplate the url template
	 * @param uriVariables the variables to expand the template
	 * @return a future that completes when the session is available
	 * @deprecated as of 6.0, in favor of {@link #execute(WebSocketHandler, String, Object...)}
	 */
	@Deprecated
	default ListenableFuture<WebSocketSession> doHandshake(WebSocketHandler webSocketHandler,
			String uriTemplate, Object... uriVariables) {
		return new CompletableToListenableFutureAdapter<>(execute(webSocketHandler, uriTemplate, uriVariables));
	}

	/**
	 * Execute a handshake request to the given url and handle the resulting
	 * WebSocket session with the given handler.
	 * @param webSocketHandler the session handler
	 * @param uriTemplate the url template
	 * @param uriVariables the variables to expand the template
	 * @return a future that completes when the session is available
	 * @since 6.0
	 */
	CompletableFuture<WebSocketSession> execute(WebSocketHandler webSocketHandler,
				String uriTemplate, Object... uriVariables);

	/**
	 * Execute a handshake request to the given url and handle the resulting
	 * WebSocket session with the given handler.
	 * @param webSocketHandler the session handler
	 * @param uri the url
	 * @return a future that completes when the session is available
	 * @deprecated as of 6.0, in favor of {@link #execute(WebSocketHandler, WebSocketHttpHeaders, URI)}
	 */
	@Deprecated
	default ListenableFuture<WebSocketSession> doHandshake(WebSocketHandler webSocketHandler,
			@Nullable WebSocketHttpHeaders headers, URI uri) {
		return new CompletableToListenableFutureAdapter<>(execute(webSocketHandler, headers, uri));
	}

	/**
	 * Execute a handshake request to the given url and handle the resulting
	 * WebSocket session with the given handler.
	 * @param webSocketHandler the session handler
	 * @param uri the url
	 * @return a future that completes when the session is available
	 * @since 6.0
	 */
	CompletableFuture<WebSocketSession> execute(WebSocketHandler webSocketHandler,
			@Nullable WebSocketHttpHeaders headers, URI uri);

}