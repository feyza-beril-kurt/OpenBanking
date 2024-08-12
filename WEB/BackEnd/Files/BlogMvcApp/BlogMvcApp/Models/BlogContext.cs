using System.Data.Entity;

namespace BlogMvcApp.Models
{
    public class BlogContext:DbContext
    {
        public DbSet<Blog> Bloglar { get; set; }
        public DbSet<Category> Kategoriler { get; set; }

    }
}
