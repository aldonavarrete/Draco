/*
 * An XML document type.
 * Localname: return
 * Namespace: http://www.sii.cl/XMLSchema
 * Java type: cl.sii.xmlSchema.ReturnDocument
 *
 * Automatically generated - do not modify.
 */
package cl.sii.xmlSchema;


/**
 * A document containing one return(@http://www.sii.cl/XMLSchema) element.
 *
 * This is a complex type.
 */
public interface ReturnDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ReturnDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0CD86E6C31202FAABC5802D2B27D90F3").resolveHandle("returnbb3fdoctype");
    
    /**
     * Gets the "return" element
     */
    cl.sii.xmlSchema.ReturnDocument.Return getReturn();
    
    /**
     * Sets the "return" element
     */
    void setReturn(cl.sii.xmlSchema.ReturnDocument.Return xreturn);
    
    /**
     * Appends and returns a new empty "return" element
     */
    cl.sii.xmlSchema.ReturnDocument.Return addNewReturn();
    
    /**
     * An XML return(@http://www.sii.cl/XMLSchema).
     *
     * This is a complex type.
     */
    public interface Return extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Return.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0CD86E6C31202FAABC5802D2B27D90F3").resolveHandle("returnf6f3elemtype");
        
        /**
         * Gets the "codResp" element
         */
        java.lang.String getCodResp();
        
        /**
         * Gets (as xml) the "codResp" element
         */
        org.apache.xmlbeans.XmlString xgetCodResp();
        
        /**
         * Sets the "codResp" element
         */
        void setCodResp(java.lang.String codResp);
        
        /**
         * Sets (as xml) the "codResp" element
         */
        void xsetCodResp(org.apache.xmlbeans.XmlString codResp);
        
        /**
         * Gets the "descResp" element
         */
        java.lang.String getDescResp();
        
        /**
         * Gets (as xml) the "descResp" element
         */
        org.apache.xmlbeans.XmlString xgetDescResp();
        
        /**
         * Sets the "descResp" element
         */
        void setDescResp(java.lang.String descResp);
        
        /**
         * Sets (as xml) the "descResp" element
         */
        void xsetDescResp(org.apache.xmlbeans.XmlString descResp);
        
        /**
         * Gets the "listaEventosDoc" element
         */
        cl.sii.xmlSchema.ReturnDocument.Return.ListaEventosDoc getListaEventosDoc();
        
        /**
         * True if has "listaEventosDoc" element
         */
        boolean isSetListaEventosDoc();
        
        /**
         * Sets the "listaEventosDoc" element
         */
        void setListaEventosDoc(cl.sii.xmlSchema.ReturnDocument.Return.ListaEventosDoc listaEventosDoc);
        
        /**
         * Appends and returns a new empty "listaEventosDoc" element
         */
        cl.sii.xmlSchema.ReturnDocument.Return.ListaEventosDoc addNewListaEventosDoc();
        
        /**
         * Unsets the "listaEventosDoc" element
         */
        void unsetListaEventosDoc();
        
        /**
         * An XML listaEventosDoc(@http://www.sii.cl/XMLSchema).
         *
         * This is a complex type.
         */
        public interface ListaEventosDoc extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ListaEventosDoc.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0CD86E6C31202FAABC5802D2B27D90F3").resolveHandle("listaeventosdoc05dcelemtype");
            
            /**
             * Gets the "codEvento" element
             */
            java.lang.String getCodEvento();
            
            /**
             * Gets (as xml) the "codEvento" element
             */
            org.apache.xmlbeans.XmlString xgetCodEvento();
            
            /**
             * Sets the "codEvento" element
             */
            void setCodEvento(java.lang.String codEvento);
            
            /**
             * Sets (as xml) the "codEvento" element
             */
            void xsetCodEvento(org.apache.xmlbeans.XmlString codEvento);
            
            /**
             * Gets the "descEvento" element
             */
            java.lang.String getDescEvento();
            
            /**
             * Gets (as xml) the "descEvento" element
             */
            org.apache.xmlbeans.XmlString xgetDescEvento();
            
            /**
             * Sets the "descEvento" element
             */
            void setDescEvento(java.lang.String descEvento);
            
            /**
             * Sets (as xml) the "descEvento" element
             */
            void xsetDescEvento(org.apache.xmlbeans.XmlString descEvento);
            
            /**
             * Gets the "rutResponsable" element
             */
            java.lang.String getRutResponsable();
            
            /**
             * Gets (as xml) the "rutResponsable" element
             */
            org.apache.xmlbeans.XmlString xgetRutResponsable();
            
            /**
             * Sets the "rutResponsable" element
             */
            void setRutResponsable(java.lang.String rutResponsable);
            
            /**
             * Sets (as xml) the "rutResponsable" element
             */
            void xsetRutResponsable(org.apache.xmlbeans.XmlString rutResponsable);
            
            /**
             * Gets the "dvResponsable" element
             */
            java.lang.String getDvResponsable();
            
            /**
             * Gets (as xml) the "dvResponsable" element
             */
            org.apache.xmlbeans.XmlString xgetDvResponsable();
            
            /**
             * Sets the "dvResponsable" element
             */
            void setDvResponsable(java.lang.String dvResponsable);
            
            /**
             * Sets (as xml) the "dvResponsable" element
             */
            void xsetDvResponsable(org.apache.xmlbeans.XmlString dvResponsable);
            
            /**
             * Gets the "fechaEvento" element
             */
            java.util.Calendar getFechaEvento();
            
            /**
             * Gets (as xml) the "fechaEvento" element
             */
            org.apache.xmlbeans.XmlDateTime xgetFechaEvento();
            
            /**
             * Sets the "fechaEvento" element
             */
            void setFechaEvento(java.util.Calendar fechaEvento);
            
            /**
             * Sets (as xml) the "fechaEvento" element
             */
            void xsetFechaEvento(org.apache.xmlbeans.XmlDateTime fechaEvento);
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static cl.sii.xmlSchema.ReturnDocument.Return.ListaEventosDoc newInstance() {
                  return (cl.sii.xmlSchema.ReturnDocument.Return.ListaEventosDoc) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static cl.sii.xmlSchema.ReturnDocument.Return.ListaEventosDoc newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (cl.sii.xmlSchema.ReturnDocument.Return.ListaEventosDoc) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static cl.sii.xmlSchema.ReturnDocument.Return newInstance() {
              return (cl.sii.xmlSchema.ReturnDocument.Return) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static cl.sii.xmlSchema.ReturnDocument.Return newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (cl.sii.xmlSchema.ReturnDocument.Return) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static cl.sii.xmlSchema.ReturnDocument newInstance() {
          return (cl.sii.xmlSchema.ReturnDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static cl.sii.xmlSchema.ReturnDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (cl.sii.xmlSchema.ReturnDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static cl.sii.xmlSchema.ReturnDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (cl.sii.xmlSchema.ReturnDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static cl.sii.xmlSchema.ReturnDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.sii.xmlSchema.ReturnDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static cl.sii.xmlSchema.ReturnDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.sii.xmlSchema.ReturnDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static cl.sii.xmlSchema.ReturnDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.sii.xmlSchema.ReturnDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static cl.sii.xmlSchema.ReturnDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.sii.xmlSchema.ReturnDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static cl.sii.xmlSchema.ReturnDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.sii.xmlSchema.ReturnDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static cl.sii.xmlSchema.ReturnDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.sii.xmlSchema.ReturnDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static cl.sii.xmlSchema.ReturnDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.sii.xmlSchema.ReturnDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static cl.sii.xmlSchema.ReturnDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.sii.xmlSchema.ReturnDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static cl.sii.xmlSchema.ReturnDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.sii.xmlSchema.ReturnDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static cl.sii.xmlSchema.ReturnDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (cl.sii.xmlSchema.ReturnDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static cl.sii.xmlSchema.ReturnDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.sii.xmlSchema.ReturnDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static cl.sii.xmlSchema.ReturnDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (cl.sii.xmlSchema.ReturnDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static cl.sii.xmlSchema.ReturnDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.sii.xmlSchema.ReturnDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.sii.xmlSchema.ReturnDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.sii.xmlSchema.ReturnDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.sii.xmlSchema.ReturnDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.sii.xmlSchema.ReturnDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
