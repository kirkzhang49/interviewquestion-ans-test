//Pull all links from the body for easy retrieval
private ArrayList pullLinks(String text) {
ArrayList links = new ArrayList();
 
String regex = "\\(?\\b(http://|www[.])[-A-Za-z0-9+&amp;@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&amp;@#/%=~_()|]";
Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(text);
while(m.find()) {
String urlStr = m.group();
if (urlStr.startsWith("(") &amp;&amp; urlStr.endsWith(")"))
{
urlStr = urlStr.substring(1, urlStr.length() - 1);
}
links.add(urlStr);
}
return links;
}
//    String regex = "\\b(https?|ftp|file)://[-A-Z0-9+&@#/%?=~_|!:,.;]*[-A-Z0-9+&@#/%=~_|]";
// Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);