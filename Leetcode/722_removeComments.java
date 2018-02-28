import java.util.ArrayList;
import java.util.List;

public class removeComments {
   public List<String> isRemoveComments(String[] source) {
	   
	   //list res
       //mode represent whether in the /*
       //meet // skip, meet /* go into mode,if mode meet */ go out
	   StringBuilder sb = new StringBuilder();
	   boolean mode = false; 
	   List<String> res = new ArrayList<>(); 
	   for (String s : source) {
		  for (int i = 0; i < s.length(); i++) {
			  if (mode) {
				  if ((s.charAt(i) == '*') && (i < s.length() - 1) && (s.charAt(i+1) == '/')) {
					 i++;
					 mode = false;
				  }
			  }
			  else {
				  if ((s.charAt(i) == '/') && (i < s.length() - 1) && (s.charAt(i+1) == '/')) {
					  break;
				  } else {
					  if (s.charAt(i) == '/' && (i < s.length() - 1) && (s.charAt(i+1) == '*')) {
						  mode = true;
						  i++;
					  } else {
						  sb.append(s.charAt(i));
					  }
				  }
			  }
		  	}
		  	if (!(mode) && (sb.length() > 0)) {
		  		res.add(sb.toString());
				sb = new StringBuilder();
		  }
	   }
	   return res;
   }
   
   public static void main(String[] args) {
	   removeComments re = new removeComments();
   }
}
