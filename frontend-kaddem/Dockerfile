FROM node:18.16 AS build
WORKDIR /app
COPY package.json ./
COPY package-lock.json ./
RUN npm install -g npm@10.2.2
COPY . .
RUN npm run build
FROM nginx:1.21.1
COPY --from=build /app/dist/vuexy /usr/share/nginx.html
EXPOSE 4200
CMD ["nginx", "-g", "daemon off;"]