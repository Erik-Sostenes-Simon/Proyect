package org.proyect.services;

import org.proyect.model.Assistance;

import java.util.Map;

interface AssistanceServices {
    public void updateAssistance(String tuition, Assistance assistance);
    public Assistance getByIdAssistance(String tuition);
}
