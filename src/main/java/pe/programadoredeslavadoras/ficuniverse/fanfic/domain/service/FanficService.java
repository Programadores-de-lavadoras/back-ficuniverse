package pe.programadoredeslavadoras.ficuniverse.fanfic.domain.service;

import pe.programadoredeslavadoras.ficuniverse.fanfic.domain.model.entitie.Fanfic;

import java.util.List;

public interface FanficService {
    Fanfic save(Fanfic fanfic);
    Fanfic update(Fanfic fanfic);

    List<Fanfic> fetchAll();

    Fanfic fetchById(Integer id);

    Fanfic findByTitle(String title);

    boolean deleteById(Integer id);

}
