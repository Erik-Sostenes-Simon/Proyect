package org.proyect.services;

import org.proyect.model.Assistance;

public interface AssistanceServices {
    public void updateAssistance(String tuition, String assistance);
    public void addAssistance(String tuition, String assistance);
    public Assistance getByIdAssistance(String tuition);
    public void deleteByIdAssistance(String tuition);
}

