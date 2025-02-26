Aşağıda, "Catch The Kenny" uygulaması için örnek bir README dosyası örneği bulabilirsiniz:

---

# Catch The Kenny

**Catch The Kenny**, Android platformu için geliştirilmiş basit bir oyundur. Oyuncunun amacı, belirli aralıklarla ekranda rastgele ortaya çıkan "Kenny" karakterine tıklayarak puan toplamaktır. Uygulama, modern Android geliştirme standartlarına uygun olarak [View Binding](https://developer.android.com/topic/libraries/view-binding) kullanılarak geliştirilmiştir.

## Özellikler

- **Rastgele Görsel Gösterimi:** Uygulama, her 500ms'de rastgele bir ImageView'i görünür hale getirir.
- **Geri Sayım Zamanlayıcısı:** 15.5 saniyelik geri sayım süresi sonunda oyun otomatik olarak sonlanır.
- **Skor Takibi:** Oyuncunun her doğru tıklamasında skor 1 artar ve ekranda güncellenir.
- **Yeniden Başlatma:** Oyuncu, oyunu sıfırlamak ve yeniden başlatmak için bir butona tıklayabilir.
- **Modern Kodlama Yaklaşımı:** `View Binding` kullanılarak, `findViewById` yerine daha güvenli ve okunabilir erişim sağlanmıştır.
- **Basit ve Temiz Kod Yapısı:** Modüler metodlar ve kapsamlı yorum satırlarıyla anlaşılır ve sürdürülebilir bir kod tabanı.

## Gereksinimler

- **Android Studio:** Uygulamayı geliştirmek ve çalıştırmak için Android Studio (4.0 ve üzeri önerilir).
- **Min SDK:** API 21 veya üzeri.
- **Gradle:** Proje Gradle yapılandırması.

## Kurulum

1. **Projeyi Klonlayın:**

   ```bash
   git clone https://github.com/kullaniciadi/CatchTheKenny.git
   ```

2. **Android Studio'da Açın:**

   - Android Studio'yu başlatın ve "Open an existing Android Studio project" seçeneğini kullanarak klonladığınız proje klasörünü seçin.

3. **Projeyi Derleyin ve Çalıştırın:**

   - Uygulamayı derlemek ve emülatör ya da gerçek cihaz üzerinde çalıştırmak için Android Studio’nun "Run" butonuna tıklayın.

## Kullanım

- **Oyun Başlangıcı:** Uygulama açıldığında, ekranda rastgele beliriren Kenny görseli görünür. 
- **Skor Artışı:** Görüntüye tıklama, skoru artırır.
- **Zamanlayıcı:** Ekranın üst kısmında geri sayım süresi gösterilir.
- **Oyun Sonu:** Süre dolduğunda, tüm görseller gizlenir ve final skor bir Toast mesajı olarak gösterilir.
- **Yeniden Başlatma:** "Yeniden Başlat" butonuna tıklanarak oyun sıfırlanır ve yeniden başlatılır.

## Kod Yapısı

- **MainActivity.kt:**  
  - Uygulamanın ana işlevselliğini barındırır.
  - `View Binding` kullanılarak layout elemanlarına erişim sağlanır.
  - `Handler` ve `Runnable` ile görselin rastgele gösterimi gerçekleştirilir.
  - `CountDownTimer` ile geri sayım süresi yönetilir.
  - Skor güncellemeleri ve yeniden başlatma işlemleri bu dosyada ele alınır.

- **ActivityMainBinding:**  
  - Layout dosyasındaki view’lerin güvenli ve tip kontrollü erişimini sağlar.

## Katkıda Bulunma

Proje ile ilgili öneri, hata bildirimi veya katkıda bulunmak isterseniz, lütfen GitHub üzerinden bir pull request oluşturun veya issue açın.

## Lisans

Bu proje, [MIT Lisansı](https://opensource.org/licenses/MIT) kapsamında lisanslanmıştır.

---
![image](https://github.com/user-attachments/assets/74e7803e-7240-417f-8622-60eb55181747)

