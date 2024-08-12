using System.Data.Entity;

namespace BlogMvcApp.Models
{
    public class BlogInitializer : DropCreateDatabaseIfModelChanges<BlogContext>
    {
        protected override void Seed(BlogContext context)
        {
            List<Category>kategoriler = new List<Category>()
            {
                new Category() { KategoriAdi = "Teknoloji" },
                new Category() { KategoriAdi = "Sağlık ve Fitness" },
                new Category() { KategoriAdi = "Finans ve Ekonomi" },
                new Category() { KategoriAdi = "Kültür ve Sanat" },
                new Category() { KategoriAdi = "Seyahat ve Gezi"},
                new Category() { KategoriAdi = "Yaşam Tarzı"}
            };
            base.Seed(context);
            foreach (var item in kategoriler)
            {
                context.Kategoriler.Add(item);
            }
            context.SaveChanges();

            List<Blog>bloglar=new List<Blog>();
            {
                new Blog()
                {
                    Baslik = "Teknoloji ile İlgili",
                    Aciklama = "Teknoloji dünyasının kapılarını aralayın; burada geleceği şekillendiren yenilikler, trendler ve etkileyici keşifler hakkında bilgi edinin.",
                    EklenmeTarihi = DateTime.Now.AddDays(-13),
                    AnaSayfa = true,
                    Onay = true,
                    İcerik = "Teknoloji bölümümüzde, dijital devrimin en yeni trendlerini ve inovasyonları keşfetmeye davetlisiniz. Akıllı cihazlardan yapay zekaya kadar pek çok alanda güncel bilgiler ve kapsamlı analizlerle teknoloji dünyasının dinamiklerini inceliyoruz.",
                    CategoryId = 1, Resim = "1.jpg"
                };
                new Blog()
                {
                    Baslik = "Sağlık ve Fitness ile İlgili",
                    Aciklama = "Sağlık ve fitness dünyasına adım atın ve kendinizi yeniden keşfedin. Enerjinizi artıracak egzersizler, yaşamınızı dönüştürecek beslenme önerileri ve motivasyon dolu içeriklerle sağlıklı bir yaşamın kapılarını aralayın.",
                    EklenmeTarihi = DateTime.Now.AddDays(-9),
                    AnaSayfa = true,
                    Onay = true,
                    İcerik = "Kendinizi daha iyi hissetmek ve güçlü bir yaşam sürmek için burada doğru yerdesiniz. Egzersiz rehberleri, sağlıklı tariflerle dolu makalelerimizle, her gününüzü daha enerjik ve dinç geçirebilirsiniz. Vücudunuzun ve ruhunuzun ihtiyaçlarını karşılamak için ilham verici içerikler sizi bekliyor.",
                    CategoryId = 2,
                    Resim = "2.jpg"
                };
                new Blog()
                {
                    Baslik = "Finans ve Ekonomi ile İlgili",
                    Aciklama = "Finans ve ekonomi dünyasına adım atarak, yatırımlarınızı büyütme ve bütçenizi yönetme konusunda bilgelik kazanın.",
                    EklenmeTarihi = DateTime.Now.AddDays(-10),
                    AnaSayfa = true,
                    Onay = true,
                    İcerik = "Stratejik yatırım ipuçlarından güncel piyasa analizlerine kadar geniş bir yelpazede içerikler sunarak, mali geleceğinizi şekillendirmenize yardımcı oluyoruz. Paranın ve ekonominin sırlarını çözerek, finansal hedeflerinize ulaşmak için ihtiyacınız olan tüm araçları sağlayın.",
                    CategoryId = 3,
                    Resim = "3.jpg"
                };
                new Blog()
                {
                    Baslik = "Kültür ve Sanat ile İlgili",
                    Aciklama = "Teknoloji dünyasının kapılarını aralayın; burada geleceği şekillendiren yenilikler, trendler ve etkileyici keşifler hakkında bilgi edinin.",
                    EklenmeTarihi = DateTime.Now.AddDays(-11),
                    AnaSayfa = true,
                    Onay = true,
                    İcerik = "Teknoloji bölümümüzde, dijital devrimin en yeni trendlerini ve inovasyonları keşfetmeye davetlisiniz. Akıllı cihazlardan yapay zekaya kadar pek çok alanda güncel bilgiler ve kapsamlı analizlerle teknoloji dünyasının dinamiklerini inceliyoruz.",
                    CategoryId = 4,
                    Resim = "4.jpg"
                };
                  new Blog()
                  {
                      Baslik = "Seyahat ve Gezi ile İlgili",
                      Aciklama = "Seyahat ve gezi makalelerimizle dünyanın dört bir yanını keşfedin ve keşiflerinizi ilham verici detaylarla zenginleştirin.",
                      EklenmeTarihi = DateTime.Now.AddDays(-7),
                      AnaSayfa = true,
                      Onay = true,
                      İcerik = "Seyahat ve gezi makalelerimizle, yeni ufuklara yelken açmanın heyecanını yaşayın. Büyüleyici destinasyonlar, gizli kalmış cennet köşeleri ve keşfetmeye değer kültürel hazineler hakkında ilham verici bilgilerle dolu içeriklerimizle, her seyahatinizi unutulmaz kılacak öneriler sunuyoruz.",
                      CategoryId = 5,
                      Resim = "5.jpg"
                  };
                    new Blog()
                    {
                        Baslik = "Yaşam Tarzı ile İlgili",
                        Aciklama = "Yaşam tarzı makalelerimiz, günlük yaşamınızı zenginleştirecek ilham verici fikirler ve pratik ipuçları sunar.",
                        EklenmeTarihi = DateTime.Now.AddDays(-10),
                        AnaSayfa = true,
                        Onay = true,
                        İcerik = "Yaşam tarzı makalelerimiz, günlük rutininizi dönüştürmek ve hayatınıza yenilik katmak için çeşitli öneriler sunar. Stil, sağlık, kişisel bakım ve yaşam kalitesi konularında ilham verici bilgilerle, kendinizi daha iyi hissetmenizi sağlayacak ipuçlarıyla doludur. Daha tatmin edici bir yaşam için ihtiyacınız olan tüm tavsiyeleri burada bulabilirsiniz.",
                        CategoryId = 6,
                        Resim = "6.jpg"
                    };
                foreach (var item in kategoriler)
                {
                    context.Kategoriler.Add(item);
                }
                context.SaveChanges();
                base.Seed(context);
            }
        }
    }
}





