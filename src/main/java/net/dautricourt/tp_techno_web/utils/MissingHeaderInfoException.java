package net.dautricourt.tp_techno_web.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by @HugoD <hg.dautricourt@gmail.com> on 07/04/2022
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MissingHeaderInfoException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public MissingHeaderInfoException(String message) {
        super(message);
    }
}
