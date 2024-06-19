# Rate My Professor App
This full stack web app allows students to rate their professors and check what other students are saying about them. This helps you to take the best courses and have a smooth experience reaching your goals!

## Setting up
The backend of the app requires:

1. OpenJDK 21
2. Postgresql 15

Clone the repository:

```sh
git clone https://github.com/chitramdasgupta/Rate-My-Professor.git
```

And then rename `application-local.properties.sample` inside `src/main/resources/` to `application-local.properties` with the `username` and `password` of your PostgreSQL setup.

You will also need to create a new database named `rmp_db`.

Import the project into your IDE of choice, and run the project.
