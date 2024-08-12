using BlogMvcApp.Models;
using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;

namespace BlogMvcApp.Controllers
{
    public class HomeController : Controller
    {
        private BlogContext context = new BlogContext();
        public ActionResult Index()
        {
            return View(context.Bloglar.ToList());
        }

       
    }
}
