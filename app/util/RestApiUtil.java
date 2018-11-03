package util;

import scala.Option;

public class RestApiUtil {

    public static boolean isSearchStrEmpty(Option<String> search){
        return search.isEmpty() || search.get().trim().isEmpty();
    }
}
