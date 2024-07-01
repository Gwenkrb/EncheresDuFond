package fr.eni.encheresdufond.dal;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.eni.encheresdufond.bo.Utilisateur;


@Repository
public class UtilisateurDAOImpl implements UtilisateurDAO {
	// Création d'un attribut JDBC Template
	private NamedParameterJdbcTemplate jdbcTemplate;

	private static final String FIND_BY_ID = "SELECT pseudo, mot_de_passe FROM UTILISATEURS WHERE no_utilisateur = :no_utilisateur";
	private static final String FIND_ALL = "SELECT * FROM UTILISATEURS";

	/**
	 * @param jdbcTemplate
	 */
	public UtilisateurDAOImpl(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * @param no_utilisateur extraire utilisateur by id
	 */
	@Override
	public Utilisateur read(long no_utilisateur) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("no_utilisateur", no_utilisateur);
		return jdbcTemplate.queryForObject(FIND_BY_ID, namedParameters, new BeanPropertyRowMapper<>(Utilisateur.class));
	}
	
	@Override
	public List<Utilisateur> findAll() {

		return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(Utilisateur.class));
	}

}
