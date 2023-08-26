package sky.pro.EmployeeBook.service.impl;

import org.springframework.stereotype.Service;
import sky.pro.EmployeeBook.exception.InvalidEmployeeDataException;
import sky.pro.EmployeeBook.service.EmployeeValidationService;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeValidationServiceImpl implements EmployeeValidationService {

    @Override
    public void validate(String firstName, String lastName) {
        validateName(firstName);
        validateName(lastName);
    }

    private void validateName(String name) {
        if (!isAlpha(name)) {
            throw new InvalidEmployeeDataException("Некорректное значение имени: " + name);
        }
    }
}
