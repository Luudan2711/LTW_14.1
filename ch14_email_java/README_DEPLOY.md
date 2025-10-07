# Deploy lên OnRender

## Bước 1: Push lên GitHub
```bash
git add .
git commit -m "Deploy to OnRender"
git push origin main
```

## Bước 2: Deploy trên OnRender
1. Vào [render.com](https://render.com)
2. New → Web Service
3. Connect GitHub repo
4. Chọn Docker environment
5. Deploy

## Files
- `Dockerfile` - Build và chạy app
- `render.yaml` - Config OnRender