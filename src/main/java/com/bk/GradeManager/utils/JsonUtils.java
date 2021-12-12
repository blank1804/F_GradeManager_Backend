package  com.bk.GradeManager.utils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonUtils {

	public static Gson gson = new Gson();
	public static ObjectMapper mapper = new ObjectMapper();

	public static <T> ArrayList<T> parseToArray(String json, Class<T> cls) {
		Type type = TypeToken.getParameterized(ArrayList.class, cls).getType();
		if (CoreUtils.isEmpty(json)) {
			return gson.fromJson("[]", type);
		}
		return gson.fromJson(json, type);
	}

	public static <T> T parseToObject(String json, Class<T> cls) {
		if (CoreUtils.isEmpty(json)) {
			return null;
		}
		Type type = TypeToken.getParameterized(cls).getType();
		return gson.fromJson(json, type);
	}

	public static <T> String toJson(T obj) {
		return gson.toJson(obj);
	}

	public static <T> T jacksonParseToObject(String json, Class<T> cls)
			throws JsonParseException, JsonMappingException, IOException {
		if (CoreUtils.isEmpty(json)) {
			return null;
		}
		return mapper.readValue(json, cls);
	}

	public static List<Map<String, Object>> parseToListMap(String json) {
		if (CoreUtils.isEmpty(json)) {
			return null;
		}
		Type resultType = new TypeToken<List<Map<String, Object>>>() {
		}.getType();
		return gson.fromJson(json, resultType);
	}

	public static Map<String, Object> parseToMap(String json) {
		if (CoreUtils.isEmpty(json)) {
			return null;
		}
		Type resultType = new TypeToken<Map<String, Object>>() {
		}.getType();
		return gson.fromJson(json, resultType);
	}

}
