package  com.bk.GradeManager.utils;

import com.google.common.base.CaseFormat;
import com.bk.GradeManager.constant.CommonConstants;


public class StringUtils {

	public static String trimWhitespace(String str) {
		if (!hasLength(str)) {
			return str;
		}
		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
			sb.deleteCharAt(0);
		}
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	public static boolean hasLength(CharSequence str) {
		return (str != null && str.length() > 0);
	}

	public static boolean hasText(CharSequence str) {
		if (!hasLength(str)) {
			return false;
		}
		int strLen = str.length();
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	public static String trimAllWhitespace(String str) {
		if (!hasLength(str)) {
			return str;
		}
		int len = str.length();
		StringBuilder sb = new StringBuilder(str.length());
		for (int i = 0; i < len; i++) {
			char c = str.charAt(i);
			if (!Character.isWhitespace(c)) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static String trimTrailingCharacter(String str, char trailingCharacter) {
		if (!hasLength(str)) {
			return str;
		}
		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && sb.charAt(sb.length() - 1) == trailingCharacter) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	public static String convetToLowerUnderScoreCase(String str) {
		return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str);
	}

	public static String padLeft(String inputString, int length, String paddingChar) {
		if (inputString.length() >= length) {
			return inputString;
		}
		StringBuilder sb = new StringBuilder();
		while (sb.length() < length - inputString.length()) {
			sb.append(paddingChar);
		}
		sb.append(inputString);

		return sb.toString();
	}

	public static String subString(String in, int length) {
		if (in.length() < length) {
			return in;
		}
		return in.substring(0, length);
	}

	public static String subStringFrom(String in, int length) {
		return in.substring(length);
	}

	public static String isEmptyToNull(String in) {
		return CoreUtils.isEmpty(in) ? null : in;
	}

	public static String concatTwoString(String s1, String s2, String centerString) {
		return CoreUtils.isNotEmpty(s1) && CoreUtils.isNotEmpty(s2)
				? s1 = (replaceAllWhitespace(s1)).concat(centerString).concat(replaceAllWhitespace(s2))
				: null;
	}

	public static String replaceAllWhitespace(String str) {
		return CoreUtils.isNotEmpty(str) ? str.replaceAll(" ", "") : null;
	}

	public static String toString(Object object) {
		if (CoreUtils.isNotNull(object)) {
			return String.valueOf(object);
		} else {
			return null;
		}
	}
	
	public static String toStringNotNull(Object object) {
		if (CoreUtils.isNotNull(object)) {
			return String.valueOf(object);
		} else {
			return CommonConstants.EMPTY_STRING;
		}
	}
}
