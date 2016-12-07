/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.webservice;

import com.feedme.dto.LogDTO;
import java.util.List;

/**
 *
 * @author Giang
 */
public interface LogService {
    boolean addLog(LogDTO log);
    boolean updateLog(LogDTO log);
    boolean removeLog(int id);
    List<LogDTO> fetchLogs(long from, long to);
    List<LogDTO> fetchLogsByEmployee(short id);
    LogDTO fetchLogById(int id);
}
