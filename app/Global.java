import java.util.Date;
import models.Surfer;
import models.SurferDB;
import models.UserInfoDB;
import play.Application;
import play.GlobalSettings;
import play.Play;
import views.formdata.SurferFormData;

public class Global extends GlobalSettings {
  
  public void onStart(Application app) {
    
    String adminEmail = Play.application().configuration().getString("digits.admin.email");
    String adminPassword = Play.application().configuration().getString("digits.admin.password");
    UserInfoDB.defineAdmin("Andrew", adminEmail, adminPassword);
    Surfer surfer3 = new Surfer("Adriano de Souza", "Sao Paulo, Brazil", "Ranked #1 on the 2013 ASP World Tour", 
        "http://epikoo.com/sites/default/files/adriano_de_souza_2.jpg", "Adriano De Souza rode his first wave at eight "
            + "years old and eight years later the surf world would take notice of this young, talented surfer at the "
            + "Billabong ASP World Junior Championships. At the 2004 event, he defeated opponents four years his senior"
            + " and was named the youngest ASP World Junior Champion ever at 16.",
        "http://thumbs.dreamstime.com/z/adriano-de-souza-quicksilver-pro-18699912.jpg", "Adriano", "Male", 0, 0,
        new Date(), "Create", "Goofy");
    Surfer surfer2 = new Surfer("Jake Marshall", "San Diego, California", "", 
        "http://www.surfingamerica.org/wp-content/uploads/2011/01/JakeMarshall2-3.jpg", "Many young surfers have the "
            + "potential to make an impact on our sport, but none look more poised to do so than Jake Marshall. "
            + "Raised on the rippable beachbreaks and reefs of San Diego's North County, Jake has developed a "
            + "solid base of smooth rail work as well as the kind of flair that few 14-year-old surfers can match.", 
            "http://www.nssa.org/photogallery/gallery/2010-11_Season/JakeMarshallPOWweb.jpg", "Jake", "Grom", 0, 0,
            new Date(), "Create", "Regular");
    Surfer surfer = new Surfer("Bethany Hamilton", "Kauai, Hawaii", "Wahine O Ke Kai (Woman of the Sea) Award at the "
        + "SIM AWaterman’s Ball (2004)", 
        "http://cdn3.dogonews.com/pictures/7220/content/Bethany-Hamilton.jpg?1302472752", "Bethany Hamilton has become "
            + "a source of inspiration to millions through her story of faith, determination, and hope. Born into a "
            + "family of surfers on February 8, 1990, on the island of Kauai, Hawaii, Bethany began surfing at a "
            + "young age. At the age of eight, Bethany entered her first surf competition, "
            + "the Rell Sun Menehune event on Oahu, where she won both the short and long board divisions. "
            + "This sparked a love for surf competition within her spirit.", 
            "http://www.bellaonline.com/review/issues/fall2012/images/PubPortrait_Cr_bethanyHamilton.jpg", "Bethany", 
            "Female", 0, 0,
            new Date(), "Create", "Regular");
    SurferDB.add(surfer.getSlug(), new SurferFormData(surfer));
    SurferDB.add(surfer2.getSlug(), new SurferFormData(surfer2));
    SurferDB.add(surfer3.getSlug(), new SurferFormData(surfer3));
  }

}