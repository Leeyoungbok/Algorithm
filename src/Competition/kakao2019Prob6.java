package Competition;

public class kakao2019Prob6 {

	public static void main(String[] args) {
		String str = "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\r\n" + 
				"<head>\r\n" + 
				"  <meta charset=\"utf-8\">\r\n" + 
				"  <meta property=\"og:url\" content=\"https://a.com\"/>\r\n" + 
				"</head>  \r\n" + 
				"<body>\r\n" + 
				"Blind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \r\n" + 
				"<a href=\"https://b.com\"> Link to b </a>\r\n" + 
				"</body>\r\n" + 
				"</html>";
		
		String[] strArr = str.split("[^a-zA-Z]");
		for(String s : strArr) {
			if(s == null || s.equals("")) continue;
			if(s.equalsIgnoreCase("blind"))
				System.out.println("찾음");
		}
	}

}
