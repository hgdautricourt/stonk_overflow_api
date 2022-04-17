package net.dautricourt.tp_techno_web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by @HugoD <hg.dautricourt@gmail.com> on 07/04/2022
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordAlreadyExistException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public RecordAlreadyExistException(String message) {
        super(message);
    }
}
