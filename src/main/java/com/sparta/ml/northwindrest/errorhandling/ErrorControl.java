package com.sparta.ml.northwindrest.errorhandling;

import com.sparta.ml.northwindrest.dto.DTO;
import com.sparta.ml.northwindrest.dto.ErrorDTO;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ErrorControl implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500";
            }
        }
        return "error-404";
    }

    public static List<DTO> emptyList() {
        ErrorDTO dto = new ErrorDTO();
        ArrayList<DTO> dtoList = new ArrayList<>();
        dtoList.add(dto);
        return dtoList;
    }

}
