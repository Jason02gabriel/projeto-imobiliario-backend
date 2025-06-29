package br.com.veneza.imoveis.services;

import br.com.veneza.imoveis.models.Usuario;
import br.com.veneza.imoveis.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public Usuario criarUsuario(Usuario usuario) {

        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        usuarios.forEach(user -> user.setSenha(null));
        return usuarios;
    }

    public Optional<Usuario> buscarPorId(Long id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        usuarioOpt.ifPresent(usuario -> usuario.setSenha(null));
        return usuarioOpt;
    }
}