PGDMP     	    6                y            School_Management    12.7 (Debian 12.7-1.pgdg90+1)    13.3 \    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16384    School_Management    DATABASE     g   CREATE DATABASE "School_Management" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.utf8';
 #   DROP DATABASE "School_Management";
                postgres    false            ?            1255    16578 ?   actualizaralumno(character varying, character varying, character varying, character varying, character varying, character varying, character varying)    FUNCTION     ?  CREATE FUNCTION public.actualizaralumno(cedvieja character varying, ced character varying, nomb character varying, email character varying, contra character varying, ape character varying, grad character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
		usuid integer;
		gradid integer;

	BEGIN
	
		UPDATE usuario 
		SET cedula = ced, 
		nombre = nomb,
		correo = email,
		contrasenna = contra,
		apellido = ape
		WHERE cedula = cedvieja;
	
		usuid := (SELECT "ID" FROM usuario WHERE cedula = ced);
		gradid := (SELECT "ID" FROM grado WHERE clase = grad);
		
		UPDATE estudiante SET "gradoId" = gradid WHERE "usuarioId" = usuid;
		
		RETURN 0;
		
	END;
$$;
 ?   DROP FUNCTION public.actualizaralumno(cedvieja character varying, ced character varying, nomb character varying, email character varying, contra character varying, ape character varying, grad character varying);
       public          Ferreto    false            ?            1255    16586 ?   actualizaralumno(character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying)    FUNCTION     ?  CREATE FUNCTION public.actualizaralumno(nombviejo character varying, apeviejo character varying, ced character varying, nomb character varying, email character varying, contra character varying, ape character varying, grad character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
		usuid integer;
		gradid integer;

	BEGIN
	
		UPDATE usuario 
		SET cedula = ced, 
		nombre = nomb,
		correo = email,
		contrasenna = contra,
		apellido = ape
		WHERE nombre = nombviejo AND apellido = apeviejo;
	
		usuid := (SELECT "ID" FROM usuario WHERE cedula = ced);
		gradid := (SELECT "ID" FROM grado WHERE clase = grad);
		
		UPDATE estudiante SET "gradoId" = gradid WHERE "usuarioId" = usuid;
		
		RETURN 0;
		
	END;
$$;
 ?   DROP FUNCTION public.actualizaralumno(nombviejo character varying, apeviejo character varying, ced character varying, nomb character varying, email character varying, contra character varying, ape character varying, grad character varying);
       public          Ferreto    false            ?            1255    16581 ?   actualizarcurso(character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying)    FUNCTION     ?  CREATE FUNCTION public.actualizarcurso(codviejo character varying, gradviejo character varying, nomb character varying, cod character varying, horain character varying, horafinal character varying, dia character varying, grad character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
	
	gradviej integer;
	gradoid integer;
	BEGIN
	
		gradviej := (SELECT "ID" FROM grado WHERE clase = gradviejo);
		gradoid := (SELECT "ID" FROM grado WHERE clase = grad);
	
		UPDATE curso 
		SET nombre = nomb,
		"horaInicio" = CAST(horaIn AS TIME WITHOUT TIME ZONE),
		"horaFin" = CAST(horaFinal AS TIME WITHOUT TIME ZONE),
		"diaSemana" = dia,
		"gradoId" = gradoid,
		codigo = cod
		WHERE codigo = codViejo AND "gradoId" = gradviej;
		
		RETURN 0;
		
	END;
$$;
 ?   DROP FUNCTION public.actualizarcurso(codviejo character varying, gradviejo character varying, nomb character varying, cod character varying, horain character varying, horafinal character varying, dia character varying, grad character varying);
       public          Ferreto    false            ?            1255    16579 ?   actualizardocente(character varying, character varying, character varying, character varying, character varying, character varying)    FUNCTION     ?  CREATE FUNCTION public.actualizardocente(cedvieja character varying, ced character varying, nomb character varying, email character varying, contra character varying, ape character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 

	BEGIN
	
		UPDATE usuario 
		SET cedula = ced, 
		nombre = nomb,
		correo = email,
		contrasenna = contra,
		apellido = ape
		WHERE cedula = cedvieja;
		
		RETURN 0;
		
	END;
$$;
 ?   DROP FUNCTION public.actualizardocente(cedvieja character varying, ced character varying, nomb character varying, email character varying, contra character varying, ape character varying);
       public          Ferreto    false            ?            1255    16585 Y   asignaralumno(character varying, character varying, character varying, character varying)    FUNCTION     ?  CREATE FUNCTION public.asignaralumno(nomchama character varying, apechama character varying, codcurs character varying, grup character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
	
	gradoid integer;
	usuid integer;
	estuid integer;
	cursoid integer;
	BEGIN
			
		gradoid := (SELECT "ID" FROM grado WHERE clase = grup);
		usuid := (SELECT "ID" FROM usuario WHERE nombre = nomchama AND apellido = apechama);
		estuid := (SELECT "ID" FROM estudiante WHERE "usuarioId" = usuid);
		cursoid := (SELECT "ID" FROM curso WHERE "gradoId" = gradoid AND codigo = codcurs);
	
		INSERT INTO "cursoXestudiante"("estudianteId", "cursoId") VALUES(estuid, cursoid); 
		
		RETURN 0;
		
	END;
$$;
 ?   DROP FUNCTION public.asignaralumno(nomchama character varying, apechama character varying, codcurs character varying, grup character varying);
       public          Ferreto    false            ?            1255    16584 E   asignarprofe(character varying, character varying, character varying)    FUNCTION     t  CREATE FUNCTION public.asignarprofe(ced character varying, codcurs character varying, grup character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
	
	gradoid integer;
	usuid integer;
	profid integer;
	cursoid integer;
	BEGIN
			
		gradoid := (SELECT "ID" FROM grado WHERE clase = grup);
		usuid := (SELECT "ID" FROM usuario WHERE cedula = ced);
		profid := (SELECT "ID" FROM profesor WHERE "usuarioId" = usuid);
		cursoid := (SELECT "ID" FROM curso WHERE "gradoId" = gradoid AND codigo = codcurs);
	
		INSERT INTO "cursoXprofesor"("profesorId", "cursoId") VALUES(profid,cursoid); 
		
		RETURN 0;
		
	END;
$$;
 m   DROP FUNCTION public.asignarprofe(ced character varying, codcurs character varying, grup character varying);
       public          Ferreto    false            ?            1255    16563 #   cursosestudiante(character varying)    FUNCTION     u  CREATE FUNCTION public.cursosestudiante(mail character varying) RETURNS TABLE(nombre character varying, codigo character varying, clase character varying)
    LANGUAGE plpgsql
    AS $$
	DECLARE 
		usuid integer;
		estid integer;		

	BEGIN
	
		usuid := (SELECT "ID" FROM usuario WHERE correo = mail);
		
		estid := (SELECT "ID" FROM estudiante WHERE "usuarioId" = usuid);
		
		 RETURN QUERY SELECT curso.nombre, curso.codigo, grado.clase FROM "cursoXestudiante"
		 INNER JOIN curso ON "cursoXestudiante"."cursoId" = curso."ID" 
		 INNER JOIN grado ON curso."gradoId" = grado."ID" 
		 WHERE "estudianteId" = estid;

		
	END;
	$$;
 ?   DROP FUNCTION public.cursosestudiante(mail character varying);
       public          Ferreto    false            ?            1255    16564 !   cursosprofesor(character varying)    FUNCTION     n  CREATE FUNCTION public.cursosprofesor(mail character varying) RETURNS TABLE(nombre character varying, codigo character varying, clase character varying)
    LANGUAGE plpgsql
    AS $$
	DECLARE 
		usuid integer;
		profid integer;		

	BEGIN
	
		usuid := (SELECT "ID" FROM usuario WHERE correo = mail);
		
		profid := (SELECT "ID" FROM profesor WHERE "usuarioId" = usuid);
		
		 RETURN QUERY SELECT curso.nombre, curso.codigo, grado.clase FROM "cursoXprofesor"
		 INNER JOIN curso ON "cursoXprofesor"."cursoId" = curso."ID" 
		 INNER JOIN grado ON curso."gradoId" = grado."ID" 
		 WHERE "profesorId" = profid;

		
	END;
	$$;
 =   DROP FUNCTION public.cursosprofesor(mail character varying);
       public          Ferreto    false            ?            1255    16577 ?   insertaralumno(character varying, character varying, character varying, character varying, character varying, character varying)    FUNCTION     c  CREATE FUNCTION public.insertaralumno(ced character varying, nomb character varying, email character varying, contra character varying, ape character varying, grad character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
		usuid integer;
		gradid integer;

	BEGIN
	
		INSERT INTO usuario(cedula, nombre, correo, contrasenna, apellido) VALUES(ced, nomb, email, contra, ape);
	
		usuid := (SELECT "ID" FROM usuario WHERE cedula = ced);
		gradid := (SELECT "ID" FROM grado WHERE clase = grad);
		
		 INSERT INTO estudiante("usuarioId","gradoId") VALUES(usuid,gradid);
		
		RETURN 0;
		
	END;
$$;
 ?   DROP FUNCTION public.insertaralumno(ced character varying, nomb character varying, email character varying, contra character varying, ape character varying, grad character varying);
       public          Ferreto    false            ?            1255    16567    insertarcurso(character varying, character varying, character varying, character varying, character varying, character varying)    FUNCTION     4  CREATE FUNCTION public.insertarcurso(cod character varying, nomb character varying, grad character varying, dia character varying, horaini character varying, horafinal character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
		gradoid integer;	

	BEGIN
	
		gradoid := (SELECT "ID" FROM grado WHERE clase = grad);	
		
		 INSERT INTO curso(nombre,codigo, "gradoId", "diaSemana", "horaInicio","horaFin") VALUES(nomb, cod, gradoid, dia, CAST(horaini AS TIME WITHOUT TIME ZONE), CAST(horafinal AS TIME WITHOUT TIME ZONE));
		
		RETURN 0;
		
	END;
$$;
 ?   DROP FUNCTION public.insertarcurso(cod character varying, nomb character varying, grad character varying, dia character varying, horaini character varying, horafinal character varying);
       public          Ferreto    false            ?            1255    16576 n   insertardocente(character varying, character varying, character varying, character varying, character varying)    FUNCTION        CREATE FUNCTION public.insertardocente(ced character varying, nomb character varying, email character varying, contra character varying, ape character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
		usuid integer;	

	BEGIN
	
		INSERT INTO usuario(cedula, nombre, correo, contrasenna, apellido) VALUES(ced, nomb, email, contra, ape);
	
		usuid := (SELECT "ID" FROM usuario WHERE cedula = ced);	
		
		 INSERT INTO profesor("usuarioId", calificacion) VALUES(usuid,0);
		
		RETURN 0;
		
	END;
$$;
 ?   DROP FUNCTION public.insertardocente(ced character varying, nomb character varying, email character varying, contra character varying, ape character varying);
       public          Ferreto    false            ?            1255    24739 H   insertarmensaje(character varying, character varying, character varying)    FUNCTION     t  CREATE FUNCTION public.insertarmensaje(cht character varying, usu character varying, msg character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 

	mensaje varchar;

	BEGIN
		mensaje := (REPLACE(msg, '_', ' '));	 	
		
		INSERT INTO mensaje("chatId", "usuarioId", texto) 
		VALUES(CAST(cht AS int), CAST(usu AS int), mensaje);
		
		RETURN 0;
		
	END;
$$;
 k   DROP FUNCTION public.insertarmensaje(cht character varying, usu character varying, msg character varying);
       public          Ferreto    false            ?            1255    16591 n   insertarnoticia(character varying, character varying, character varying, character varying, character varying)    FUNCTION     ?  CREATE FUNCTION public.insertarnoticia(cod character varying, grad character varying, tit character varying, cont character varying, fech character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
		cursoid integer;
		gradoid integer;
		titNuevo character varying;
		contNuevo character varying;

	BEGIN
		contNuevo := (REPLACE(cont, '_', ' '));
	    titNuevo := (REPLACE(tit, '_', ' '));
		gradoid := (SELECT "ID" FROM grado WHERE clase = grad);
		cursoid := (SELECT "ID" FROM curso WHERE "gradoId" = gradoid AND codigo = cod);	
		
		INSERT INTO noticia("cursoId", titulo, descripcion, fecha) 
		VALUES(cursoid, titNuevo, contNuevo, CAST(fech AS date));
		
		RETURN 0;
		
	END;
$$;
 ?   DROP FUNCTION public.insertarnoticia(cod character varying, grad character varying, tit character varying, cont character varying, fech character varying);
       public          Ferreto    false            ?            1255    16590    insertartarea(character varying, character varying, character varying, character varying, character varying, character varying)    FUNCTION     ?  CREATE FUNCTION public.insertartarea(cod character varying, grad character varying, tit character varying, cont character varying, codtarea character varying, fech character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
		cursoid integer;
		gradoid integer;
		titNuevo character varying;
		contNuevo character varying;

	BEGIN
		contNuevo := (REPLACE(cont, '_', ' '));
	    titNuevo := (REPLACE(tit, '_', ' '));
		gradoid := (SELECT "ID" FROM grado WHERE clase = grad);
		cursoid := (SELECT "ID" FROM curso WHERE "gradoId" = gradoid AND codigo = cod);	
		
		INSERT INTO tarea("cursoId", titulo, descripcion, codigo, fecha) 
		VALUES(cursoid, titNuevo, contNuevo, codtarea, CAST(fech AS date));
		
		RETURN 0;
		
	END;
$$;
 ?   DROP FUNCTION public.insertartarea(cod character varying, grad character varying, tit character varying, cont character varying, codtarea character varying, fech character varying);
       public          Ferreto    false            ?            1259    16437    administrador    TABLE     c   CREATE TABLE public.administrador (
    "ID" integer NOT NULL,
    "usuarioId" integer NOT NULL
);
 !   DROP TABLE public.administrador;
       public         heap    Ferreto    false            ?            1259    16435    administrador_ID_seq    SEQUENCE     ?   ALTER TABLE public.administrador ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."administrador_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          Ferreto    false    211            ?            1259    16495    chat    TABLE     X   CREATE TABLE public.chat (
    "ID" integer NOT NULL,
    "cursoId" integer NOT NULL
);
    DROP TABLE public.chat;
       public         heap    Ferreto    false            ?            1259    16493    chat_ID_seq    SEQUENCE     ?   ALTER TABLE public.chat ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."chat_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          Ferreto    false    219            ?            1259    16449    curso    TABLE     <  CREATE TABLE public.curso (
    "ID" integer NOT NULL,
    nombre character varying(30) NOT NULL,
    "gradoId" integer NOT NULL,
    "horaInicio" time without time zone NOT NULL,
    codigo character varying(10) NOT NULL,
    "horaFin" time without time zone NOT NULL,
    "diaSemana" character varying NOT NULL
);
    DROP TABLE public.curso;
       public         heap    Ferreto    false            ?            1259    16478    cursoXestudiante    TABLE     ?   CREATE TABLE public."cursoXestudiante" (
    "ID" integer NOT NULL,
    "cursoId" integer NOT NULL,
    "estudianteId" integer NOT NULL
);
 &   DROP TABLE public."cursoXestudiante";
       public         heap    Ferreto    false            ?            1259    16476    cursoXestudiante_ID_seq    SEQUENCE     ?   ALTER TABLE public."cursoXestudiante" ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."cursoXestudiante_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          Ferreto    false    217            ?            1259    16461    cursoXprofesor    TABLE     ?   CREATE TABLE public."cursoXprofesor" (
    "ID" integer NOT NULL,
    "profesorId" integer NOT NULL,
    "cursoId" integer NOT NULL
);
 $   DROP TABLE public."cursoXprofesor";
       public         heap    Ferreto    false            ?            1259    16459    cursoXprofesor_ID_seq    SEQUENCE     ?   ALTER TABLE public."cursoXprofesor" ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."cursoXprofesor_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          Ferreto    false    215            ?            1259    16447    curso_ID_seq    SEQUENCE     ?   ALTER TABLE public.curso ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."curso_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          Ferreto    false    213            ?            1259    16413 
   estudiante    TABLE     ?   CREATE TABLE public.estudiante (
    "ID" integer NOT NULL,
    "usuarioId" integer NOT NULL,
    "gradoId" integer NOT NULL
);
    DROP TABLE public.estudiante;
       public         heap    Ferreto    false            ?            1259    16411    estudiante_ID_seq    SEQUENCE     ?   ALTER TABLE public.estudiante ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."estudiante_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          Ferreto    false    207            ?            1259    16425    grado    TABLE     c   CREATE TABLE public.grado (
    "ID" integer NOT NULL,
    clase character varying(10) NOT NULL
);
    DROP TABLE public.grado;
       public         heap    Ferreto    false            ?            1259    16423    grado_ID_seq    SEQUENCE     ?   ALTER TABLE public.grado ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."grado_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          Ferreto    false    209            ?            1259    16507    mensaje    TABLE     ?   CREATE TABLE public.mensaje (
    "ID" integer NOT NULL,
    texto character varying(300) NOT NULL,
    "chatId" integer NOT NULL,
    "usuarioId" integer NOT NULL
);
    DROP TABLE public.mensaje;
       public         heap    Ferreto    false            ?            1259    16505    mensaje_ID_seq    SEQUENCE     ?   ALTER TABLE public.mensaje ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."mensaje_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          Ferreto    false    221            ?            1259    16524    noticia    TABLE     ?   CREATE TABLE public.noticia (
    "ID" integer NOT NULL,
    titulo character varying(100) NOT NULL,
    descripcion character varying(300) NOT NULL,
    "cursoId" integer NOT NULL,
    fecha date
);
    DROP TABLE public.noticia;
       public         heap    Ferreto    false            ?            1259    16522    noticia_ID_seq    SEQUENCE     ?   ALTER TABLE public.noticia ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."noticia_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          Ferreto    false    223            ?            1259    16401    profesor    TABLE     ?   CREATE TABLE public.profesor (
    "ID" integer NOT NULL,
    "usuarioId" integer NOT NULL,
    calificacion integer NOT NULL
);
    DROP TABLE public.profesor;
       public         heap    Ferreto    false            ?            1259    16399    profesor_ID_seq    SEQUENCE     ?   ALTER TABLE public.profesor ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."profesor_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          Ferreto    false    205            ?            1259    16536    tarea    TABLE     ?   CREATE TABLE public.tarea (
    "ID" integer NOT NULL,
    titulo character varying(150) NOT NULL,
    descripcion character varying(300) NOT NULL,
    "cursoId" integer NOT NULL,
    codigo character varying(10) NOT NULL,
    fecha date
);
    DROP TABLE public.tarea;
       public         heap    Ferreto    false            ?            1259    16534    tarea_ID_seq    SEQUENCE     ?   ALTER TABLE public.tarea ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."tarea_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          Ferreto    false    225            ?            1259    16391    usuario    TABLE       CREATE TABLE public.usuario (
    "ID" integer NOT NULL,
    nombre character varying(20) NOT NULL,
    apellido character varying(20) NOT NULL,
    contrasenna character varying(25) NOT NULL,
    cedula character varying(12) NOT NULL,
    correo character varying(30) NOT NULL
);
    DROP TABLE public.usuario;
       public         heap    Ferreto    false            ?            1259    16389    usuario_ID_seq    SEQUENCE     ?   ALTER TABLE public.usuario ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."usuario_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          Ferreto    false    203            ?          0    16437    administrador 
   TABLE DATA           :   COPY public.administrador ("ID", "usuarioId") FROM stdin;
    public          Ferreto    false    211   ??       ?          0    16495    chat 
   TABLE DATA           /   COPY public.chat ("ID", "cursoId") FROM stdin;
    public          Ferreto    false    219   ??       ?          0    16449    curso 
   TABLE DATA           f   COPY public.curso ("ID", nombre, "gradoId", "horaInicio", codigo, "horaFin", "diaSemana") FROM stdin;
    public          Ferreto    false    213   ݐ       ?          0    16478    cursoXestudiante 
   TABLE DATA           M   COPY public."cursoXestudiante" ("ID", "cursoId", "estudianteId") FROM stdin;
    public          Ferreto    false    217   ԑ       ?          0    16461    cursoXprofesor 
   TABLE DATA           I   COPY public."cursoXprofesor" ("ID", "profesorId", "cursoId") FROM stdin;
    public          Ferreto    false    215   ?       ?          0    16413 
   estudiante 
   TABLE DATA           B   COPY public.estudiante ("ID", "usuarioId", "gradoId") FROM stdin;
    public          Ferreto    false    207   I?       ?          0    16425    grado 
   TABLE DATA           ,   COPY public.grado ("ID", clase) FROM stdin;
    public          Ferreto    false    209   ??       ?          0    16507    mensaje 
   TABLE DATA           E   COPY public.mensaje ("ID", texto, "chatId", "usuarioId") FROM stdin;
    public          Ferreto    false    221   ˒       ?          0    16524    noticia 
   TABLE DATA           N   COPY public.noticia ("ID", titulo, descripcion, "cursoId", fecha) FROM stdin;
    public          Ferreto    false    223   ??       ?          0    16401    profesor 
   TABLE DATA           C   COPY public.profesor ("ID", "usuarioId", calificacion) FROM stdin;
    public          Ferreto    false    205   ??       ?          0    16536    tarea 
   TABLE DATA           T   COPY public.tarea ("ID", titulo, descripcion, "cursoId", codigo, fecha) FROM stdin;
    public          Ferreto    false    225   ؓ       ?          0    16391    usuario 
   TABLE DATA           V   COPY public.usuario ("ID", nombre, apellido, contrasenna, cedula, correo) FROM stdin;
    public          Ferreto    false    203   ??       ?           0    0    administrador_ID_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public."administrador_ID_seq"', 2, true);
          public          Ferreto    false    210            ?           0    0    chat_ID_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public."chat_ID_seq"', 1, true);
          public          Ferreto    false    218            ?           0    0    cursoXestudiante_ID_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public."cursoXestudiante_ID_seq"', 6, true);
          public          Ferreto    false    216            ?           0    0    cursoXprofesor_ID_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public."cursoXprofesor_ID_seq"', 6, true);
          public          Ferreto    false    214            ?           0    0    curso_ID_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public."curso_ID_seq"', 35, true);
          public          Ferreto    false    212            ?           0    0    estudiante_ID_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public."estudiante_ID_seq"', 6, true);
          public          Ferreto    false    206            ?           0    0    grado_ID_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public."grado_ID_seq"', 9, true);
          public          Ferreto    false    208            ?           0    0    mensaje_ID_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public."mensaje_ID_seq"', 1, false);
          public          Ferreto    false    220            ?           0    0    noticia_ID_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public."noticia_ID_seq"', 9, true);
          public          Ferreto    false    222            ?           0    0    profesor_ID_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public."profesor_ID_seq"', 6, true);
          public          Ferreto    false    204            ?           0    0    tarea_ID_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public."tarea_ID_seq"', 4, true);
          public          Ferreto    false    224            ?           0    0    usuario_ID_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public."usuario_ID_seq"', 25, true);
          public          Ferreto    false    202                       2606    16441     administrador administrador_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.administrador
    ADD CONSTRAINT administrador_pkey PRIMARY KEY ("ID");
 J   ALTER TABLE ONLY public.administrador DROP CONSTRAINT administrador_pkey;
       public            Ferreto    false    211                       2606    16499    chat chat_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.chat
    ADD CONSTRAINT chat_pkey PRIMARY KEY ("ID");
 8   ALTER TABLE ONLY public.chat DROP CONSTRAINT chat_pkey;
       public            Ferreto    false    219                       2606    16482 &   cursoXestudiante cursoXestudiante_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public."cursoXestudiante"
    ADD CONSTRAINT "cursoXestudiante_pkey" PRIMARY KEY ("ID");
 T   ALTER TABLE ONLY public."cursoXestudiante" DROP CONSTRAINT "cursoXestudiante_pkey";
       public            Ferreto    false    217                       2606    16465 "   cursoXprofesor cursoXprofesor_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public."cursoXprofesor"
    ADD CONSTRAINT "cursoXprofesor_pkey" PRIMARY KEY ("ID");
 P   ALTER TABLE ONLY public."cursoXprofesor" DROP CONSTRAINT "cursoXprofesor_pkey";
       public            Ferreto    false    215                       2606    16453    curso curso_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.curso
    ADD CONSTRAINT curso_pkey PRIMARY KEY ("ID");
 :   ALTER TABLE ONLY public.curso DROP CONSTRAINT curso_pkey;
       public            Ferreto    false    213                       2606    16417    estudiante estudiante_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.estudiante
    ADD CONSTRAINT estudiante_pkey PRIMARY KEY ("ID");
 D   ALTER TABLE ONLY public.estudiante DROP CONSTRAINT estudiante_pkey;
       public            Ferreto    false    207                       2606    16429    grado grado_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.grado
    ADD CONSTRAINT grado_pkey PRIMARY KEY ("ID");
 :   ALTER TABLE ONLY public.grado DROP CONSTRAINT grado_pkey;
       public            Ferreto    false    209                       2606    16511    mensaje mensaje_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.mensaje
    ADD CONSTRAINT mensaje_pkey PRIMARY KEY ("ID");
 >   ALTER TABLE ONLY public.mensaje DROP CONSTRAINT mensaje_pkey;
       public            Ferreto    false    221                       2606    16528    noticia noticia_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.noticia
    ADD CONSTRAINT noticia_pkey PRIMARY KEY ("ID");
 >   ALTER TABLE ONLY public.noticia DROP CONSTRAINT noticia_pkey;
       public            Ferreto    false    223            
           2606    16405    profesor profesor_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT profesor_pkey PRIMARY KEY ("ID");
 @   ALTER TABLE ONLY public.profesor DROP CONSTRAINT profesor_pkey;
       public            Ferreto    false    205                       2606    16540    tarea tarea_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.tarea
    ADD CONSTRAINT tarea_pkey PRIMARY KEY ("ID");
 :   ALTER TABLE ONLY public.tarea DROP CONSTRAINT tarea_pkey;
       public            Ferreto    false    225                       2606    16395    usuario usuario_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY ("ID");
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            Ferreto    false    203            )           2606    16512    mensaje chatId    FK CONSTRAINT     q   ALTER TABLE ONLY public.mensaje
    ADD CONSTRAINT "chatId" FOREIGN KEY ("chatId") REFERENCES public.chat("ID");
 :   ALTER TABLE ONLY public.mensaje DROP CONSTRAINT "chatId";
       public          Ferreto    false    219    221    2840            %           2606    16471    cursoXprofesor cursoId    FK CONSTRAINT     }   ALTER TABLE ONLY public."cursoXprofesor"
    ADD CONSTRAINT "cursoId" FOREIGN KEY ("cursoId") REFERENCES public.curso("ID");
 D   ALTER TABLE ONLY public."cursoXprofesor" DROP CONSTRAINT "cursoId";
       public          Ferreto    false    2834    215    213            '           2606    16488    cursoXestudiante cursoId    FK CONSTRAINT        ALTER TABLE ONLY public."cursoXestudiante"
    ADD CONSTRAINT "cursoId" FOREIGN KEY ("cursoId") REFERENCES public.curso("ID");
 F   ALTER TABLE ONLY public."cursoXestudiante" DROP CONSTRAINT "cursoId";
       public          Ferreto    false    217    213    2834            (           2606    16500    chat cursoId    FK CONSTRAINT     q   ALTER TABLE ONLY public.chat
    ADD CONSTRAINT "cursoId" FOREIGN KEY ("cursoId") REFERENCES public.curso("ID");
 8   ALTER TABLE ONLY public.chat DROP CONSTRAINT "cursoId";
       public          Ferreto    false    2834    219    213            +           2606    16529    noticia cursoId    FK CONSTRAINT     t   ALTER TABLE ONLY public.noticia
    ADD CONSTRAINT "cursoId" FOREIGN KEY ("cursoId") REFERENCES public.curso("ID");
 ;   ALTER TABLE ONLY public.noticia DROP CONSTRAINT "cursoId";
       public          Ferreto    false    223    213    2834            *           2606    16517    mensaje escritorId    FK CONSTRAINT     {   ALTER TABLE ONLY public.mensaje
    ADD CONSTRAINT "escritorId" FOREIGN KEY ("usuarioId") REFERENCES public.usuario("ID");
 >   ALTER TABLE ONLY public.mensaje DROP CONSTRAINT "escritorId";
       public          Ferreto    false    203    221    2824            &           2606    16483    cursoXestudiante estudianteId    FK CONSTRAINT     ?   ALTER TABLE ONLY public."cursoXestudiante"
    ADD CONSTRAINT "estudianteId" FOREIGN KEY ("estudianteId") REFERENCES public.estudiante("ID");
 K   ALTER TABLE ONLY public."cursoXestudiante" DROP CONSTRAINT "estudianteId";
       public          Ferreto    false    2828    217    207            !           2606    16430    estudiante gradoId    FK CONSTRAINT     ?   ALTER TABLE ONLY public.estudiante
    ADD CONSTRAINT "gradoId" FOREIGN KEY ("gradoId") REFERENCES public.grado("ID") NOT VALID;
 >   ALTER TABLE ONLY public.estudiante DROP CONSTRAINT "gradoId";
       public          Ferreto    false    209    2830    207            #           2606    16454    curso gradoId    FK CONSTRAINT     r   ALTER TABLE ONLY public.curso
    ADD CONSTRAINT "gradoId" FOREIGN KEY ("gradoId") REFERENCES public.grado("ID");
 9   ALTER TABLE ONLY public.curso DROP CONSTRAINT "gradoId";
       public          Ferreto    false    209    2830    213            $           2606    16466    cursoXprofesor profesorId    FK CONSTRAINT     ?   ALTER TABLE ONLY public."cursoXprofesor"
    ADD CONSTRAINT "profesorId" FOREIGN KEY ("profesorId") REFERENCES public.profesor("ID");
 G   ALTER TABLE ONLY public."cursoXprofesor" DROP CONSTRAINT "profesorId";
       public          Ferreto    false    2826    205    215            ,           2606    16541    tarea ursod    FK CONSTRAINT     n   ALTER TABLE ONLY public.tarea
    ADD CONSTRAINT ursod FOREIGN KEY ("cursoId") REFERENCES public.curso("ID");
 5   ALTER TABLE ONLY public.tarea DROP CONSTRAINT ursod;
       public          Ferreto    false    213    225    2834                       2606    16406    profesor usuarioId    FK CONSTRAINT     {   ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT "usuarioId" FOREIGN KEY ("usuarioId") REFERENCES public.usuario("ID");
 >   ALTER TABLE ONLY public.profesor DROP CONSTRAINT "usuarioId";
       public          Ferreto    false    203    205    2824                        2606    16418    estudiante usuarioId    FK CONSTRAINT     }   ALTER TABLE ONLY public.estudiante
    ADD CONSTRAINT "usuarioId" FOREIGN KEY ("usuarioId") REFERENCES public.usuario("ID");
 @   ALTER TABLE ONLY public.estudiante DROP CONSTRAINT "usuarioId";
       public          Ferreto    false    2824    203    207            "           2606    16442    administrador usuarioId    FK CONSTRAINT     ?   ALTER TABLE ONLY public.administrador
    ADD CONSTRAINT "usuarioId" FOREIGN KEY ("usuarioId") REFERENCES public.usuario("ID");
 C   ALTER TABLE ONLY public.administrador DROP CONSTRAINT "usuarioId";
       public          Ferreto    false    203    2824    211            ?      x?3?4?2?4?????? !?      ?      x?3?4?????? ]      ?   ?   x?eP;R?0?W???^??????"]????-Y?g?by?E?????̾???)6??]?5???лG??A8??`fw\P??w?e+V?f?b*3??Z{	S[90??/ߡ Q?]A?O??C?
?????C*28E7???f'?ۉk??gY?ta]L?%?#?ɷK???gd??_Sz???w?f??)J%?yN???????T?nj
???*{?,ܖ]?u?`+?xu?WJ] ?1kV      ?   )   x?3?4?4?2?F\&??@6?q?p?q?r?q??qqq W??      ?   ,   x?%??   ???0&?0??ϡ??6?|?ERn616C??;K?z??      ?   /   x???  ??eD
?`????,AiasTD?J|??'KƝ7$}?q?      ?   3   x??? ! A?[??O/gN?	?f?s??̈́?l?بv???d???K???      ?      x?????? ? ?      ?   ?   x?M?A
?0E??)???*?C?.?L?#q?N?B?????q?????;s??H???2?5??^?e????] CP?$?q??W?m?j{0??{?gb?C?L??cY??z?g!x?2?0??.J??fo[?2????<?^?#w?3??
???dg?k?I?F:      ?   /   x?ǹ  ?x?ā???ׁ?ј?5??&6]??$??§xM?|b?      ?   ?   x?M?1?0Eg??@Q``??#??zJ??i??i??Ų???m?????2??9eh?J?4??S?q󰗈?\??????{j???g?SŰKڇE9Õ?q?דG?YYK??B/l??ϯ)?{X?OQ??? ??7VY??7mƯ????5kG3      ?   ?  x?}?A??0E??)?I?le?4??h??M?ꆱ[Y?Hv?ɭz?^???`P?$????????C?6?߼????S???P???ږFC??~q}????cM??????+?>??	
cu??U?<Ol?+J?{Lѽ???>S??iH.6.??????Uo????k'0???T?F	Q?#gLnŔ??Mr~?= <O.??(Y???_x?x?q?T???:؅9?Z?@JSVڔ
rG??CX1>?kOpt??Bh%@+i??FB?3?ݬ??????'???|?;?pv??F??P?#?@e?'??!yL???v?????K??)k_o֨䖌??=?O?=????VT?_??=??ǩ??B}d???δ??S?V7?????W?%?20?ɝP?t?7tX?P/hv?ϼ?ư)%wW??ѷ??u????B??g????,d^O?p@b9??"OA??b?z_w[???s.ʛbk>?z?4O{?;??}]Z-?.?5?ⱂ~>n6??+Y     