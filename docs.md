## Set up the database

The first thing to do is set up `postgresql`.

Ensure that:

1. A new user is created along with a password
2. The database is created
3. The user can connect to the database

## Directory structure is by feature

http://www.javapractices.com/topic/TopicAction.do?Id=205

## The general flow

1. Write a migration with the proper naming convention in 
`src/main/resources/db/migration/`.
2. Write the entity for the migration, with the column names
and the validations, along with the boilerplate.
3. Iterate between writing migrations and updating the entity.
4. Write the repository interface for each entity.