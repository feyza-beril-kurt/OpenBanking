﻿namespace BlogMvcApp.Models
{
    public class Blog
    {
        public int Id { get; set; }
        public string Baslik { get; set; }
        public string Resim { get; set; }
        public string Aciklama { get; set; }
        public string İcerik { get; set; }
        public DateTime EklenmeTarihi { get; set; }
        public bool Onay { get; set; }
        public bool AnaSayfa { get; set; }
        public int CategoryId { get; set; }
        public Category Category { get; set; }


    }
}
