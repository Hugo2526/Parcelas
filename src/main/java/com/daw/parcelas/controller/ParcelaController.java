package com.daw.parcelas.controller;

import com.daw.parcelas.model.Parcela;
import com.daw.parcelas.model.TipoCultivo;
import com.daw.parcelas.service.ParcelaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/parcelas")
public class ParcelaController {

    private final ParcelaService parcelaService;

    public ParcelaController(ParcelaService parcelaService) {
        this.parcelaService = parcelaService;
    }

    //Mostrar todas las parcelas
    @GetMapping
    public String listar(Model model) {

        model.addAttribute("parcelas", parcelaService.listarTodas());
        model.addAttribute("superficieTotal", parcelaService.superficieTotal());
        model.addAttribute("tipos", TipoCultivo.values());

        return "parcelas/lista"; // -> temlates/parcelas/lista.html
    }


    //Muestra el detalle de una parcela al buscarla por ID
    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        model.addAttribute("parcela", parcelaService.buscarPorId(id));
        return "parcelas/detalle";
    }


    //Crea un formulario para crear una parcela nueva
    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("parcela", new Parcela());
        model.addAttribute("tipos", TipoCultivo.values());
        return "parcelas/formulario";
    }


    //Guarda la nueva parcela hecha y te redirige a la lista de parcelas
    @PostMapping
    public String guardar(@ModelAttribute Parcela parcela) {
        parcelaService.guardar(parcela);
        return "redirect:/parcelas";
    }


    //Elimina una parcela por ID y redirige a la lista de parcelas
    @PostMapping("/{id}/eliminar")
    public String eliminar(@PathVariable Long id) {
        parcelaService.eliminar(id);
        return "redirect:/parcelas";
    }

    //Muestra las parcelas filtradas por tipo de cultivo
    @GetMapping("/cultivo/{tipo}")
    public String filtrarPorCultivo(@PathVariable String tipo, Model model) {

        model.addAttribute("parcelas", parcelaService.findByTipoCultivo(TipoCultivo.valueOf(tipo)));
        model.addAttribute("superficieTotal", parcelaService.superficieTotal());
        model.addAttribute("tipos", TipoCultivo.values());

        return "parcelas/lista";

    }

    //Muestra las parcelas ordenado por nombre asc
    @GetMapping("/asc")
    public String findAllByOrderByNombreAsc(Model model) {
        model.addAttribute("parcelas", parcelaService.findAllByOrderByNombreAsc());
        model.addAttribute("superficieTotal", parcelaService.superficieTotal());
        model.addAttribute("tipos", TipoCultivo.values());
        return "parcelas/lista";
    }


    //edición de hay una parcela existente
    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model) {

        Parcela parcela = parcelaService.buscarPorId(id);

        if (parcela == null) {
            return "redirect:/parcelas";
        }

        model.addAttribute("parcela", parcela);
        model.addAttribute("tipos", TipoCultivo.values());
        return "parcelas/formulario";
    }
}
