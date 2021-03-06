/*
 * Copyright 2019 icefrog.su@qq.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.icefrog.terminal.util;

import java.util.HashMap;
import java.util.Map;

public class BaseService {
	protected ApiResult apiResult = new ApiResult();
	
	/**
	 * Clean and rebuild ApiResult object
	 */
	protected void clear() {
		apiResult = new ApiResult();
	}
	
	protected ApiResult success(String functionid, String message, String key, Object value) {
		Map<String, Object> data = new HashMap<String, Object>(1);
		data.put(key, value);
		return callme(ApiResult.CODE_SUCCESS, functionid, message, data);
	}

	protected ApiResult success(String functionid, String message, Map<String, Object> data) {
		return callme(ApiResult.CODE_SUCCESS, functionid, message, data);
	}

	protected ApiResult success(String functionid, String message) {
		return callme(ApiResult.CODE_SUCCESS, functionid, message, null);
	}

	protected ApiResult success(String functionid, Map<String, Object> data) {
		return callme(ApiResult.CODE_SUCCESS, functionid, ApiResult.SUCCESS_MESSAGE, data);
	}

	protected ApiResult success(String functionid) {
		return callme(ApiResult.CODE_SUCCESS, functionid, ApiResult.SUCCESS_MESSAGE, null);
	}

	protected ApiResult error(String functionid, String message, String key, Object value) {
		Map<String, Object> data = new HashMap<String, Object>(1);
		data.put(key, value);
		return callme(ApiResult.CODE_FAILED, functionid, message, data);
	}

	protected ApiResult error(String functionid, String message, Map<String, Object> data) {
		return callme(ApiResult.CODE_FAILED, functionid, message, data);
	}

	protected ApiResult error(String functionid, String message) {
		return callme(ApiResult.CODE_FAILED, functionid, message, null);
	}

	protected ApiResult error(String functionid, Map<String, Object> data) {
		return callme(ApiResult.CODE_FAILED, functionid, ApiResult.SUCCESS_MESSAGE, data);
	}

	protected ApiResult error(String functionid) {
		return callme(ApiResult.CODE_FAILED, functionid, ApiResult.FAILED_MESSAGE, null);
	}

	protected ApiResult custome(String functionid, String message, int code, Map<String, Object> data) {
		return callme(code, functionid, message, data);
	}

	protected ApiResult custome(String functionid, String message, int code) {
		return callme(code, functionid, message, null);
	}

	protected ApiResult custome(String functionid, int code, Map<String, Object> data) {
		return callme(code, functionid, ApiResult.SUCCESS_MESSAGE, data);
	}

	protected ApiResult custome(String functionid, int code) {
		return callme(code, functionid, ApiResult.SUCCESS_MESSAGE, null);
	}

	private ApiResult callme(Integer code, String functionid, String message, Map<String, Object> params) {
		return apiResult.setCode(code).setFunctionID(functionid).setMessage(message).setData(params);
	}
}
