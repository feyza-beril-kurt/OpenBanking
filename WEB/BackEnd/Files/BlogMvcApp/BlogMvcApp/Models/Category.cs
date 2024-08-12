namespace BlogMvcApp.Models
{
    public class Category
    {
        public int Id { get; set; }
        public string KategoriAdi { get; set; }
        public List<Blog> Bloglar { get; set; }

    }
}
