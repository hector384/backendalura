package com.project.alura.service;
import com.project.alura.DTO.UsuarioDto;
import com.project.alura.entity.Usuario;
import com.project.alura.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioServiceImplementation implements  UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public Usuario NewUser(Usuario usuario) {
        if (usuarioRepository.existsBynombre(usuario.getNombre())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nombre already exists");
        }
        if (usuarioRepository.existsBycorreo(usuario.getCorreo())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Correo already exists");
        }
        return usuarioRepository.save(usuario);

    }


    private UsuarioDto convertToDtoU(Usuario usuario) {
        return new UsuarioDto(

                usuario.getId(),
                usuario.getContrasena(),
                usuario.getCorreo(),
                usuario.getNombre(),
                usuario.getPerfiles()

        );
    }
}
