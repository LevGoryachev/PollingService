package ru.goryachev.pollingservice.exception;

import java.util.List;

/**
 * Exception если в теле запроса нет одного или нескольких ключевых properties
 * Например, для post запроса в SpResult нужен составной ключ из трёх ID, данное исключение подойдет для случая, если один из них null
 * Принимает список пропертей, которые не найдены
 * @author Lev Goryachev
 * @version 1
 */
public class KeyPropertiesNotFoundException extends RuntimeException {
    public KeyPropertiesNotFoundException(List<String> undetectedProps) {
        super(String.format("Necessary properties: %s not found in yor request body", String.join(", ", undetectedProps)));
    }
}
