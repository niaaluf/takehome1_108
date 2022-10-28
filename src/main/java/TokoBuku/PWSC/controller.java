/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TokoBuku.PWSC;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author asus
 */
@Controller
public class controller {
    
    tablecontroller result = new tablecontroller();
    @RequestMapping("/Input")
    
    public String getHasll(HttpServletRequest data, Model model) {
        String getNama = data.getParameter("NamaBuku");
        int getJumlah = Integer.parseInt(data.getParameter("JumlahBuku"));
        int getHarga = Integer.parseInt(data.getParameter("HargaBuku"));
        
        int diskon = result.getharga(getJumlah, getHarga);
        int compute = result.gethitung(getJumlah, getHarga);
        
        model.addAttribute("Nama",getNama);
        model.addAttribute("Barang", getJumlah);
        model.addAttribute("Harga", ("Rp. "+ getHarga));
        model.addAttribute("Total", ("Rp. "+(getHarga*getJumlah)));
        model.addAttribute("Diskon", "Rp. "+ compute);
        model.addAttribute("TotalDiskon", diskon + " %");
        
        return "tableviewer";
    }
}
