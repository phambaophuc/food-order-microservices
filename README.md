# Food Ordering API
![Spring Boot Version](https://img.shields.io/badge/springboot-3.2.0-green)
![Java Version](https://img.shields.io/badge/java-17-orange)
[![License](https://img.shields.io/badge/license-MIT-blue)](LICENSE)

Dự án này là một hệ thống microservice sử dụng Spring Boot, bao gồm các dịch vụ sau:
- API Gateway
- Eureka Server
- Auth Service
- Order Service
- Product Service
- Review Service

## Mô tả

Dự án API này cung cấp các endpoints để quản lý việc đặt đồ ăn trong nhà hàng.

## Cài đặt và chạy

### Yêu cầu

- JDK 11 hoặc mới hơn
- Maven
- Docker (tùy chọn)

### Cài đặt và chạy từ mã nguồn

1. Clone repository này: `git clone https://github.com/phambaophuc/food-order-microservices.git`
2. Di chuyển vào thư mục dự án: `cd your_project`
3. Sử dụng Maven để biên dịch dự án: `mvn clean package`
4. Khởi động từng dịch vụ một theo thứ tự sau:
   - Eureka Server: `java -jar eureka-server/target/eureka-server.jar`
   - API Gateway: `java -jar api-gateway/target/api-gateway.jar`
   - Auth Service: `java -jar auth-service/target/auth-service.jar`
   - Order Service: `java -jar order-service/target/order-service.jar`
   - Product Service: `java -jar product-service/target/product-service.jar`
   - Review Service: `java -jar review-service/target/review-service.jar`

### Cài đặt và chạy bằng Docker

1. Clone repository này: `git clone https://github.com/phambaophuc/food-order-microservices.git`
2. Di chuyển vào thư mục dự án: `cd your_project`
3. Xây dựng images Docker cho từng dịch vụ: `mvn clean package && docker-compose build`
4. Khởi động các container Docker: `docker-compose up`

## Hướng dẫn sử dụng

Sau khi tất cả các dịch vụ đã được khởi động, bạn có thể truy cập vào API của từng dịch vụ thông qua API Gateway. 

## Tài liệu

Thông tin chi tiết về API, truy cập Swagger UI: [http://localhost:8765/swagger-ui.html](http://localhost:8765/swagger-ui.html)
