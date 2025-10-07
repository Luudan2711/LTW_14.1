# Deploy Java Email App lên OnRender

## 📋 Prerequisites

1. Tài khoản GitHub
2. Tài khoản OnRender (miễn phí)
3. Code đã được push lên GitHub repository

## 🚀 Hướng dẫn Deploy

### Bước 1: Push code lên GitHub

```bash
# Khởi tạo git repository (nếu chưa có)
git init

# Add all files
git add .

# Commit
git commit -m "Initial commit - Java Email App"

# Add remote repository
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPOSITORY.git

# Push to GitHub
git push -u origin main
```

### Bước 2: Deploy trên OnRender

1. **Đăng nhập OnRender**: Truy cập [render.com](https://render.com) và đăng nhập
2. **New Web Service**: Click "New" → "Web Service"
3. **Connect Repository**: Chọn GitHub repository của bạn
4. **Cấu hình:**
   - **Name**: `ch14-email-java`
   - **Environment**: `Docker`
   - **Region**: `Singapore` (gần Việt Nam nhất)
   - **Branch**: `main`
   - **Dockerfile Path**: `./Dockerfile`
   - **Plan**: `Free` (0$/tháng)

5. **Environment Variables** (tuỳ chọn):
   ```
   JAVA_OPTS = -Xmx512m -Xms256m
   ```

6. **Deploy**: Click "Create Web Service"

### Bước 3: Kiểm tra Deployment

- OnRender sẽ tự động build và deploy
- Quá trình build có thể mất 5-10 phút
- URL của ứng dụng sẽ có dạng: `https://ch14-email-java.onrender.com`

## 🔧 Files cần thiết

- `Dockerfile` - Cấu hình container
- `.dockerignore` - Loại trừ files không cần thiết  
- `render.yaml` - Cấu hình OnRender (tuỳ chọn)
- `pom.xml` - Đã cập nhật để hỗ trợ deployment

## 📝 Lưu ý

1. **Free Plan Limitations:**
   - App sẽ sleep sau 15 phút không hoạt động
   - Có thể mất 30-60s để wake up
   - 750 giờ/tháng miễn phí

2. **Database:**
   - Đang sử dụng H2 in-memory
   - Data sẽ mất khi app restart
   - Nếu cần persistent data, chuyển sang PostgreSQL

3. **Email Configuration:**
   - Gmail credentials đã được cấu hình
   - Kiểm tra App Password còn hợp lệ

## 🌐 Truy cập ứng dụng

Sau khi deploy thành công:
- URL: `https://YOUR_APP_NAME.onrender.com`
- Test form email tại trang chủ
- Email sẽ được gửi từ `luudan2711@gmail.com`

## 🐛 Troubleshooting

1. **Build failed:** Kiểm tra logs trong OnRender dashboard
2. **App không start:** Kiểm tra port configuration
3. **Email không gửi:** Kiểm tra Gmail App Password
4. **500 Error:** Kiểm tra database connection