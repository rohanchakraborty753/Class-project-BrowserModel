public class BrowserTest
{
		public static void main (String [] args)
		{
			WebBrowser b = new WebBrowser();
			System.out.println ("CURRENT PAGE: " + b.currentPage());
            System.out.println ("BOOKMARK IT :  " + b.bookmark());
			String site = "http://www.espn.com";
			System.out.println ("LOADING: " + site + " ... " + b.load(site));
			System.out.println ("CURRENT PAGE: " + b.currentPage()); 
         
			site = "www.invalid.com";
			System.out.println ("LOADING: " + site + " ... " + b.load(site));
			System.out.println ("CURRENT PAGE: " + b.currentPage());
			
			System.out.println ("GOING BACK TO: " + b.goBack());
			System.out.println ("CURRENT PAGE:  " + b.currentPage());
			System.out.println ("GOING FWD TO:  " + b.goForward());
			System.out.println ("CURRENT PAGE:  " + b.currentPage());
			System.out.println (b.history());
			
			site = "http://www.thebeatles.com";
			System.out.println ("LOADING: " + site + " ... " + b.load(site));
			System.out.println ("CURRENT PAGE:  " + b.currentPage());
         System.out.println ("BOOKMARK IT :  " + b.bookmark());
         
         
			System.out.println (b.history());
         System.out.println (b.getBookmarks());
	}
}		