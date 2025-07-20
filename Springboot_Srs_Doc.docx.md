# Yazılım Gereksinim Dokümanı (SRS)

## 1\. Giriş

### 1.1 Amaç

Bu Software Requirements Specification belgesi, Muhammed Fatih Asan tarafından Spring Boot ile geliştirilmiş makale paylaşımı, yorumlama, kategori ve beğeni işlemlerini içeren web uygulamasının backend sisteminin teknik ve fonksiyonel gereksinimlerini açıklamayı amaçlar.

### 1.2 Kapsam

Bu doküman, yalnızca uygulamanın backend bileşenlerini (REST API servislerini) kapsar. Frontend ve yetkilendirme mekanizmaları kapsam dışıdır.

### 1.3 Terimler ve Kısaltmalar

* **DTO:** Data Transfer Object

* **DAO:** Data Access Object

* **CRU:** Create, Read, Update

* **REST API:** Representational State Transfer Application Programming Interface

### 1.4 Kaynaklar

* Spring Boot 3.5.3 resmi dokümantasyonu

* PostgreSQL resmi dokümantasyonu

* OpenAPI (Swagger) resmi dokümantasyonu

### 1.5 Genel Bakış

Sistem kullanıcıların makale oluşturmasına, yorum eklemesine, kategorilere göre sınıflandırmasına ve makaleleri beğenmesine olanak sağlayan REST tabanlı backend servislerinden oluşur.

---

## 2\. Genel Açıklama

### 2.1 Ürün Perspektifi

Ürün, öğrenme amaçlı geliştirilen, yerel ortamda çalışan bir Spring Boot backend uygulamasıdır. Java 24 sürümü kullanılmıştır.

### 2.2 Ürün Özellikleri

* Makale oluşturma, güncelleme ve listeleme

* Makaleleri kategoriye göre filtreleme

* Yorum ekleme ve güncelleme

* Makale beğenme özelliği

### 2.3 Kullanıcı Profili

Şu aşamada tek tip kullanıcı (kayıtlı kullanıcılar) bulunmaktadır. Admin ya da farklı kullanıcı rolleri henüz yoktur.

### 2.4 Varsayımlar ve Kısıtlamalar

* Uygulama yalnızca backend olarak geliştirilmiştir.

* Kimlik doğrulama ve yetkilendirme sistemi mevcut değildir.

* Uygulama yerel (localhost) ortamında çalışır.

---

## 3\. Fonksiyonel Gereksinimler

### 3.1 Endpoint Bazlı İşlevler

* Makale CRU (create, read, update)

* Yorum CRU

* Kategori CRU

* Makale beğenme ve ilişkilendirme işlemleri

* Filtreleme ve sayfalama işlemleri

**Not:** Delete işlemi mevcut değildir. İlerleyen aşamalarda silme işlemi yerine aktif/pasif hale getirme planlanmaktadır.

### 3.2 DTO Kullanımı ve Veri Doğrulama

DTO yapılarıyla endpoint’lere gelen veri kontrollü şekilde yönetilir. Validasyon Spring Boot Validation kullanılarak sağlanır.

### 3.3 Exception Yönetimi ve Yanıt Modeli

Global exception handler kullanılarak uygulama genelinde tutarlı ve anlaşılır hata mesajları oluşturulur. Tüm endpoint’ler için ortak Result ve türevi (ErrorResult, DataResult) yanıt modelleri kullanılır.

---

## 4\. Sistem Yapısı

### 4.1 Katmanlı Mimari Açıklaması

Proje aşağıdaki katman yapısına sahiptir:

* api.controllers (REST endpoint yönetimi)

* business (iş kuralları)

* core (ortak işlevler, exception yönetimi, veri dönüşüm işlemleri)

* dataAccess.abstracts (veritabanı işlemleri)

* entities (Entity ve DTO)

* security (güvenlik yapılandırması)

### 4.2 Veritabanı Modeli ve Tablolar

PostgreSQL veritabanında passport, user, article, comment, category, article\_like, article\_category tabloları bulunur. (ER diyagramı ekte)

### 4.3 Swagger/OpenAPI Entegrasyonu

SpringDoc OpenAPI kullanılarak endpoint dokümantasyonu otomatik oluşturulmuştur ve Swagger arayüzünden erişilebilir.

### 4.4 Rollback Planı

Veritabanı işlemlerinde oluşabilecek hatalar durumunda ilişkili kayıtların geri alınmasını sağlayacak bir plan önerisi bulunmaktadır.

### 4.5 Geliştirmeye Açık Noktalar

* Active/Passive endpoint’leri (silme yerine durum değiştirme)

* Global loglama

* İşlemler arası transaction yönetimi

---

## 5\. Ekler

* ER diyagramı


  


  


  


  


  


  


  


  


* Swagger UI ekran görüntüleri

\~\~\~\~\~\~\~

