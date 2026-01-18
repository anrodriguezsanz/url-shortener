# URL Shortener Service

URL Shortener application built with **Spring Boot**, **H2 Database**, and **Thymeleaf**. This application allows you to convert long URLs into short and uniquelinks.

## Features

*   **Shorten URLs**: Convert any long URL into a short, unique link.
*   **Redirection**: Automatically redirects users from the short link to the original URL.
*   **Persistence**: Uses an embedded H2 database (file-based) to store mappings, ensuring data persists across restarts.
*   **Asynchronous Processing**: Uses jQuery/AJAX to avoid page reloads.

## Technologies Used

*   **Java 17**
*   **Spring Boot 3.2.3** (Web, Data JPA, Thymeleaf)
*   **H2 Database** (Embedded SQL database)
*   **Frontend**: HTML5, CSS3, Bootstrap 5, jQuery
*   **Build Tool**: Maven

## Prerequisites

*   Java Development Kit (JDK) 17 or higher installed.

## Installation & Running

1.  **Clone the repository**:
    ```bash
    git clone https://github.com/anrodriguezsanz/url-shortener.git
    cd url-shortener
    ```

2.  **Run the application**:
    You can run the application using the included Maven Wrapper:
    ```bash
    ./mvnw spring-boot:run
    ```
    *(On Windows, use `mvnw.cmd spring-boot:run`)*

3.  **Access the application**:
    Open your web browser and go to:
    http://localhost:8080

## Database Configuration

The application uses an H2 database stored in a local file.

*   **Database File**: `./data/url_db`
*   **H2 Console**: Enabled at `/h2-console`

To access the database console:
1.  Navigate to http://localhost:8080/h2-console
2.  Use the following credentials (defined in `application.properties`):
    *   **JDBC URL**: `jdbc:h2:file:./data/url_db`
    *   **User Name**: `sa`
    *   **Password**: `password`

## API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/` | Returns the home page. |
| `POST` | `/` | Accepts a parameter `original-url` and returns the shortened URL string. |
| `GET` | `/{id}` | Redirects to the original URL associated with the given ID. |

## Project Structure

```
src/
├── main/
│   ├── java/com/example/url_shortener/
│   │   ├── UrlShortenerApplication.java  # Main entry point
│   │   ├── UrlShortenerController.java   # Web Controller
│   │   ├── UrlShortenerService.java      # Business Logic
│   │   ├── UrlRepository.java            # Data Access Layer
│   │   └── UrlMapping.java               # Database Entity
│   └── resources/
│       ├── static/                       # CSS, JS
│       ├── templates/                    # HTML Views
│       └── application.properties        # Configuration
```

## Author

*   **Andrea Rodriguez** - [GitHub Profile](https://github.com/your-username)
