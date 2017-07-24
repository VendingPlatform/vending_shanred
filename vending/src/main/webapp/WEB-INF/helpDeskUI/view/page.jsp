<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="table-footer">
                                    <div class="table-result pull-left color-lightslategray">
                                        当前第：
                                        <span class="result-index color-inverse">${requestScope.pageVO.currPage}</span>
                                        页
                                    共查找到：
                                        <span class="result-number color-badger">${requestScope.pageVO.counts}</span>
                                        条数据
                                    </div>
                                    <!-- /table-result -->
                                    <nav class="pagination-custom-wrap">
                                        <ul class=" pagination-custom">
                                            <li class="active">
                                                <a href="javascript:UserManagement.goPage(1);" aria-label="true">首页</a>
                                                <!-- <input type="button" value="首页" onClick="goPage(1);" /> -->
                                            </li>
                                            <li >
                                                <c:choose>
												<c:when test="${requestScope.pageVO.currPage==1}">
												    <a href="javascript:UserManagement.goPage(1);" aria-label="true">«上一页</a>
													<!-- <input type="button" value="上一页" onclick="goPage(1);" /> -->
												</c:when>
												<c:otherwise>
												    <a href="javascript:UserManagement.goPage(${requestScope.pageVO.currPage-1});" aria-label="true">«上一页</a>
													<%-- <input type="button" value="上一页"
														onclick="goPage(${requestScope.pageVO.currPage-1});" /> --%>
												</c:otherwise>
											</c:choose>
                                            </li>

                                            <li>
                                                <c:choose>
												<c:when
													test="${requestScope.pageVO.currPage==requestScope.pageVO.pageTotal}">
													<a href="javascript:UserManagement.goPage(${requestScope.pageVO.pageTotal});" aria-label="Next">
                                                        <span aria-hidden="true">下一页»</span>
                                                    </a>
													<%-- <input type="button" value="下一页"
														onclick="goPage(${requestScope.pageVO.pageTotal});" /> --%>
												</c:when>
												<c:otherwise>
												    <a href="javascript:UserManagement.goPage(${requestScope.pageVO.currPage+1});" aria-label="Next">
                                                        <span aria-hidden="true">下一页»</span>
                                                    </a>
													<%-- <input type="button" value="下一页"
														onclick="goPage(${requestScope.pageVO.currPage+1});" /> --%>
												</c:otherwise>
											</c:choose>
                                            </li>
                                            <li >
                                                 <a href="javascript:UserManagement.goPage(${requestScope.pageVO.pageTotal});" aria-label="Previous">尾页</a>
                                                <%-- <input type="button" value="尾页"
												onClick="goPage(${requestScope.pageVO.pageTotal});" /> --%>
                                            </li>
                                        </ul>
                                        <div class="pagination-custom-result color-lightslategray">
                                            <div class="pagination-total">
                                                共
                                                <span class="total">${requestScope.pageVO.pageTotal}</span>
                                                页，
                                            </div>
                                            <div class="pagination-to">
                                                到
                                                <input type="text" class="form-control" value=""
											    id="pageText">页</div>

                                            <button class="btn btn-default pagination-custom-btn" type="button" onclick="goPage($('#pageText').val());">确定</button>
                                        </div>
                                    </nav>
                                    <!-- /nav --> </div>
                                <!-- /table-footer --> </div>
                            <!-- /panel-body --> </div>
                        <!-- /panel --> </div>
                    <!-- /col-md-12 --> </div>
                <!-- /row --> </div>
            <!-- /container-fluid --> </div>
        <!-- /page-content -->
        <div class="page-footer">
            <p class="copyright pull-left color-lightslategray">
                © 2015 Copyright
                <a href="http://www.gm-medicare.com/" target="_blank">GM-Medicare.com</a>
                All Rights Reserved 版权所有
            </p>
            <p class="theme-author pull-right">
                <i class="icon-envelope-letter color-badger"></i>
                by
                <a href="mailto:lilonglong@gm-medicare.com">李龙龙</a>
            </p>
        </div>
        <!-- /page-footer --> </div>