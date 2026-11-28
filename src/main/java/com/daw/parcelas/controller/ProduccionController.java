package com.daw.parcelas.controller;

import com.daw.parcelas.model.Calidad;
import com.daw.parcelas.model.Produccion;
import com.daw.parcelas.model.Producto;
import com.daw.parcelas.service.ProduccionServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/producciones")
public class ProduccionController {

    private final ProduccionServiceImpl produccionService;

    public ProduccionController(
            ProduccionServiceImpl produccionService) {
        this.produccionService = produccionService;
    }

    @GetMapping
    public String listar(@RequestParam(required = false) String producto,
                         @RequestParam(required = false) String calidad,
                         Model model) {

        if (producto == null) producto = "TODOS";
        if (calidad == null) calidad = "TODOS";

        List<Produccion> producciones = produccionService.filtrarProductoYCalidad(producto, calidad);
        model.addAttribute("producciones", producciones);
        model.addAttribute("producto", producto);
        model.addAttribute("calidad", calidad);
        model.addAttribute("produccionesTotal", producciones.size());
        model.addAttribute("totalKg", produccionService.calcularTotalKilos(producciones));
        model.addAttribute("productos", Producto.values());
        model.addAttribute("calidades", Calidad.values());
        return "producciones/lista";
    }

    @GetMapping("/new")
    public String nueva(Model model) {
        Produccion produccion = new Produccion();
        produccion.setFechaRecoleccion(LocalDate.now());
        model.addAttribute("produccion", produccion);
        model.addAttribute("productos", Producto.values());
        model.addAttribute("calidades", Calidad.values());
        return "producciones/formulario";
    }

    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        model.addAttribute("produccion", produccionService.buscarPorId(id));
        return "producciones/detalle";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("produccion") Produccion produccion, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("productos", Producto.values());
            model.addAttribute("calidades", Calidad.values());
            return "producciones/formulario";
        }
        produccionService.guardar(produccion);
        return "redirect:/producciones";
    }

    @PostMapping("/delete/{id}")
    public String eliminar(@PathVariable Long id) {
        produccionService.eliminar(id);
        return "redirect:/producciones";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("produccion",produccionService.buscarPorId(id));
        model.addAttribute("productos", Producto.values());
        model.addAttribute("calidades", Calidad.values());
        return "producciones/formulario";
    }
}