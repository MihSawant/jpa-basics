# enumerated-types
In this module i have used the enumerated annotation
as sometimes in the entity we may have to store certain types
and we can do it with help of _**Enums**_ 
in java, but in in order to understand it by mysql we have to 
use Enumerated Annotation and specify the value, by defaut it is ordinal
and other option is String.

### enumerated-type-ordinal
If we specify the value to be ordinal then in mysql table hibernate will use no.s 
to identity the types, in this example i have used shoe entity and to store the currency
of shoes, there are two types Indian Rupees and U.S. Dollars, for INR it will use 0 and for USD it will use 1.
No. is used for the type.

![img.png](img.png)

### enumerated-type-string
In this case if we changed the value to string then hibernate will 
take the name of the type which is specified in Enum, so 
here in Currency i have added one more type EUR and when i persist
the entities, then in table it will store the name of type as string

**_Also the type of currency attribute is changed to VARCHAR so that we can
because we are storing String as the type and not INT._**

![img_1.png](img_1.png)


# temporal types

### Using LocalDate type
Using LocalDate we can store _**only Date**_ in the table and using DATE type in MYSQL DB,
here employees Joining Date is stored using DATE mapped as LocalDate in Java.

![img_2.png](img_2.png)

### Using LocalDateTime type
By using the LocalDateTime in the Entity and setting the TIMESTAMP in the database,
hibernate will map the column with that of java type, and it will persist both Date and Time.

![img_3.png](img_3.png)

### Using ZonedDateTime 
We changed the LocalDateTime with ZonedDateTime in order to store
time with respect to different time zones like of  Chicago and Sydney, but
hibernate is not able to store the time as Chicago and Sydney are completely
different time zones still for both it is persisting same Hour.

![img_4.png](img_4.png)