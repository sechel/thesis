<?xml version="1.0" encoding="UTF-8"?>
<stylesheet version="1.0" 
	xmlns="http://www.w3.org/1999/XSL/Transform"
	xmlns:svg="http://www.w3.org/2000/svg"
>
 	<output version="1.0" indent="yes" method="xml" standalone="yes"/>
	<template match="/svg">
		<element name="svg" namespace="http://www.w3.org/2000/svg">
			<attribute name="version">1.1</attribute>
			<copy-of select="@viewBox"/>
			<apply-templates select="child::node()"/>
		</element>
	</template>
	
	<template match="polygon">
		<element name="polygon" namespace="http://www.w3.org/2000/svg">
		<if test="@id">
			<copy-of select="@id"/>
		</if>
		<if test="not(@id)">
			<attribute name="id">
				<value-of select="concat('polygon', position())"/>
			</attribute>
		</if>
		<attribute name="style">fill:none; stroke:<value-of select="@fill"/>;stroke-width:0.25</attribute>
		<copy-of select="@points"/>
		</element>
	</template>
</stylesheet>