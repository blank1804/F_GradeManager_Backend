//package  com.bk.GradeManager.utils;
//
//import java.util.Collection;
//
//import org.apache.commons.text.RandomStringGenerator;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.jwt.Jwt;
//
//public class UserUtils {
//	
//	public static String getToken() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (CoreUtils.isNotNull(authentication)) {
//			Jwt principal = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            return principal.getTokenValue();
//        }
//        return null; 
//	}
//
//	public static String getBearerToken() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (CoreUtils.isNotNull(authentication)) {
//			Jwt principal = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            return "Bearer "+principal.getTokenValue();
//        }
//        return null; 
//	}
//
//	public static String getUsername() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (CoreUtils.isNotNull(authentication)) {
//			Jwt principal = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            return principal.getClaimAsString("name");
//        }
//        return "System"; 
//	}
//
//	public static String getCompanyCode() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (CoreUtils.isNotNull(authentication)) {
//			Jwt principal = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            return principal.getClaimAsString("company");
//        }
//        return null; 
//	}
//
//	public static String getPrincipalByKey(String key) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (CoreUtils.isNotNull(authentication)) {
//			Jwt principal = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            return principal.getClaimAsString(key);
//        }
//        return null; 
//	}
//
//	public static String getAuthorityByKey(String key)  {
//		Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
//		String result = null;
//		JSONArray jsonarray = new JSONArray(authorities.toString());
//		for (int i = 0; i < jsonarray.length(); i++) {
//			JSONObject jsonobject = jsonarray.getJSONObject(i);
//			if(CoreUtils.isNotEmpty(jsonobject.optString(key))) {
//				result = jsonobject.optString(key);
//			}
//		}
//		return result.replaceAll("\\[", "").replaceAll("\\]","");
//	}
//	
//	public static String generateRandomSpecialCharacters(int length) {
//	    RandomStringGenerator pwdGenerator = new RandomStringGenerator.Builder().withinRange(33, 45)
//	        .build();
//	    return pwdGenerator.generate(length);
//	}
//
//	public static String hashPassword(String passWord) throws Exception {
//		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String hashPassword = passwordEncoder.encode(passWord);
//		return hashPassword;
//	}
//	
//}