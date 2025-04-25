# Etapa 1: Construcción del frontend
FROM node:18 AS builder

WORKDIR /app
COPY . .

RUN npm install
RUN npm run build

# Etapa 2: Servir el frontend con NGINX
FROM nginx:alpine

COPY --from=builder /app/dist /usr/share/nginx/html

# Copia archivo de configuración opcional si usas rutas personalizadas
# COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
